import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[3][3];
        int oCount = 0, xCount = 0;

        for (int i = 0; i < 3; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < 3; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'O') oCount++;
                if (board[i][j] == 'X') xCount++;
            }
        }

        boolean oWin = isWin(board, 'O');
        boolean xWin = isWin(board, 'X');

        boolean valid = true;

        // 규칙 1: O는 항상 X보다 같거나 하나 더 많아야 함
        if (xCount > oCount || oCount - xCount > 1) valid = false;

        // 규칙 2: 둘 다 이기면 안 됨
        if (oWin && xWin) valid = false;

        // O가 이겼다면 O가 X보다 1개 많아야 함
        if (oWin && oCount != xCount + 1) valid = false;

        // X가 이겼다면 O와 X 개수가 같아야 함
        if (xWin && oCount != xCount) valid = false;

        System.out.println(valid ? 1 : 0);
    }

    private static boolean isWin(char[][] board, char player) {
        // 가로/세로
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player &&
                board[i][1] == player &&
                board[i][2] == player) return true;

            if (board[0][i] == player &&
                board[1][i] == player &&
                board[2][i] == player) return true;
        }
        // 대각선
        if (board[0][0] == player &&
            board[1][1] == player &&
            board[2][2] == player) return true;

        if (board[0][2] == player &&
            board[1][1] == player &&
            board[2][0] == player) return true;

        return false;
    }
}
