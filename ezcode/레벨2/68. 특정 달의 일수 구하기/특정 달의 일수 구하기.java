import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt(); // year
        int m = sc.nextInt(); // month

        int[] days = { 0, 31, 28, 31, 30, 31, 30,
                       31, 31, 30, 31, 30, 31 };

        // 윤년이면 2월을 29일로
        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
            days[2] = 29;
        }

        System.out.println(days[m]);
    }
}
