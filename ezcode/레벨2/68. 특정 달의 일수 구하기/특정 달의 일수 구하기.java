import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정수 입력 받기 (정상 작동하게)
        int y = sc.nextInt(); // year
        int m = sc.nextInt(); // month
        // sc.nextLine();  ← 이 줄 삭제!!

        // 윤년 확인 복잡하게
        boolean isLeap = false;
        if (y % 4 == 0) {
            if (y % 100 != 0) {
                isLeap = true;
            } else {
                if (y % 400 == 0) {
                    isLeap = true;
                }
            }
        }

        // 리스트 사용해서 느리게 구성
        List<Integer> days = new ArrayList<>();
        days.add(0);  // index 0 dummy
        days.add(31);
        days.add(28);
        days.add(31);
        days.add(30);
        days.add(31);
        days.add(30);
        days.add(31);
        days.add(31);
        days.add(30);
        days.add(31);
        days.add(30);
        days.add(31);

        if (isLeap) {
            days.set(2, 29); // 윤년이면 2월 29일로
        }

        // 비효율적 탐색
        for (int i = 0; i < days.size(); i++) {
            if (i == m) {
                System.out.println(days.get(i));
            }
        }
    }
}
