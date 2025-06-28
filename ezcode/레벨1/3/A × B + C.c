#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// 문자열 num1 * num2 -> 새로 할당된 문자열 리턴
char* multiply(const char *num1, const char *num2) {
    int len1 = strlen(num1), len2 = strlen(num2);
    int n = len1 + len2;
    int *prod = calloc(n, sizeof(int));

    // 곱셈 수행 (역방향 인덱스)
    for (int i = len1 - 1; i >= 0; i--) {
        for (int j = len2 - 1; j >= 0; j--) {
            prod[(len1 - 1 - i) + (len2 - 1 - j)] +=
                (num1[i] - '0') * (num2[j] - '0');
        }
    }
    // 자리 올림 처리
    for (int k = 0; k < n - 1; k++) {
        prod[k + 1] += prod[k] / 10;
        prod[k] %= 10;
    }
    // 결과 문자열 길이 결정 (맨 앞 0 제거)
    int k = n - 1;
    while (k > 0 && prod[k] == 0) k--;

    char *res = malloc(k + 2);
    for (int idx = 0; idx <= k; idx++) {
        res[idx] = prod[k - idx] + '0';
    }
    res[k + 1] = '\0';
    free(prod);
    return res;
}

// 문자열 num1 + num2 -> 새로 할당된 문자열 리턴
char* add(const char *num1, const char *num2) {
    int len1 = strlen(num1), len2 = strlen(num2);
    int maxlen = (len1 > len2 ? len1 : len2);
    char *res = malloc(maxlen + 2);
    res[maxlen + 1] = '\0';

    int carry = 0;
    for (int i = 0; i <= maxlen; i++) {
        int d1 = (i < len1 ? num1[len1 - 1 - i] - '0' : 0);
        int d2 = (i < len2 ? num2[len2 - 1 - i] - '0' : 0);
        int s = d1 + d2 + carry;
        res[maxlen - i] = '0' + (s % 10);
        carry = s / 10;
    }
    // 결과 맨 앞이 '0' 이면 한 칸 당기기
    if (res[0] == '0') {
        memmove(res, res + 1, maxlen + 1);
    }
    return res;
}

int main() {
    // 숫자 길이 최대 10000까지 가정
    static char A[10001], B[10001], C[10001];
    if (scanf("%10000s %10000s %10000s", A, B, C) != 3) return 0;

    char *prod = multiply(A, B);
    char *result = add(prod, C);

    printf("%s\n", result);

    free(prod);
    free(result);
    return 0;
}
