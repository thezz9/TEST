#include <stdio.h>

int main() {
    int y, m;
    scanf("%d %d", &y, &m); // y: year, m: month

    int days[] = { 0, 31, 28, 31, 30, 31, 30,
                   31, 31, 30, 31, 30, 31 };

    // 윤년이면 2월을 29일로
    if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) {
        days[2] = 29;
    }

    printf("%d\n", days[m]);

    return 0;
}
