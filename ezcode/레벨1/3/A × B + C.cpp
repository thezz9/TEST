#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

// 문자열 곱셈
string multiply(const string &num1, const string &num2) {
    int n1 = num1.size(), n2 = num2.size();
    vector<int> prod(n1 + n2, 0);
    for (int i = n1 - 1; i >= 0; --i) {
        for (int j = n2 - 1; j >= 0; --j) {
            prod[(n1 - 1 - i) + (n2 - 1 - j)] += 
                (num1[i] - '0') * (num2[j] - '0');
        }
    }
    // 자리올림 처리
    for (int i = 0; i < (int)prod.size() - 1; ++i) {
        prod[i+1] += prod[i] / 10;
        prod[i] %= 10;
    }
    // 결과 문자열로 변환 (맨 앞 0 제거)
    int k = prod.size() - 1;
    while (k > 0 && prod[k] == 0) --k;
    string res;
    res.reserve(k+1);
    for (int i = k; i >= 0; --i) 
        res.push_back(char('0' + prod[i]));
    return res;
}

// 문자열 덧셈
string add(const string &num1, const string &num2) {
    int n1 = num1.size(), n2 = num2.size();
    int maxlen = max(n1, n2);
    string res(maxlen+1, '0');
    int carry = 0;
    for (int i = 0; i <= maxlen; ++i) {
        int d1 = i < n1 ? num1[n1-1-i] - '0' : 0;
        int d2 = i < n2 ? num2[n2-1-i] - '0' : 0;
        int s = d1 + d2 + carry;
        res[maxlen - i] = char('0' + (s % 10));
        carry = s / 10;
    }
    // 맨 앞 0이 남으면 잘라내기
    if (res[0] == '0') 
        return res.substr(1);
    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string A, B, C;
    if (!(cin >> A >> B >> C)) 
        return 0;

    // A * B + C
    string prod = multiply(A, B);
    string result = add(prod, C);
    cout << result << "\n";
    return 0;
}
