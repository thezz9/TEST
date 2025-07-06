import java.util.*;

public class Main {
    static int H, W;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        while (T-- > 0) {
            H = sc.nextInt();
            W = sc.nextInt();
            sc.nextLine(); // 줄바꿈 처리

            grid = new char[H][W];
            visited = new boolean[H][W];

            // 그리드 입력
            for (int i = 0; i < H; i++) {
                String line = sc.nextLine();
                grid[i] = line.toCharArray();
            }

            int count = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (grid[i][j] == '#' && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    // 깊이 우선 탐색
    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < H && ny < W) {
                if (!visited[nx][ny] && grid[nx][ny] == '#') {
                    dfs(nx, ny);
                }
            }
        }
    }
}
