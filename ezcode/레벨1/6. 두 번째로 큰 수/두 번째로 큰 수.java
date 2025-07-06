import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = sc.nextInt();
        }

        // 최대값, 두 번째로 큰 값 초기화
        int first = -1;
        int second = -1;

        for (int num : nums) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num < first) {
                second = num;
            }
        }

        // 두 번째로 큰 값의 처음 위치 찾기 (1-based index)
        int position = -1;
        for (int i = 0; i < 10; i++) {
            if (nums[i] == second) {
                position = i + 1;
                break;
            }
        }

        System.out.println(second);
        System.out.println(position);
    }
}
