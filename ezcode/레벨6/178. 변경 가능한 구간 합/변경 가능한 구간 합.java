import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static long[] arr, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 배열 크기
        M = Integer.parseInt(st.nextToken()); // 갱신 횟수
        K = Integer.parseInt(st.nextToken()); // 합 조회 횟수

        arr = new long[N + 1];
        tree = new long[N * 4];

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        build(1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                long diff = c - arr[b];
                arr[b] = c;
                update(1, 1, N, b, diff);
            } else if (a == 2) {
                sb.append(query(1, 1, N, b, (int) c)).append('\n');
            }
        }

        System.out.print(sb);
    }

    // 트리 구성
    static void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    // 값 갱신
    static void update(int node, int start, int end, int idx, long diff) {
        if (idx < start || idx > end) return;
        tree[node] += diff;
        if (start == end) return;
        int mid = (start + end) / 2;
        update(node * 2, start, mid, idx, diff);
        update(node * 2 + 1, mid + 1, end, idx, diff);
    }

    // 구간 합 조회
    static long query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) return 0;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right)
             + query(node * 2 + 1, mid + 1, end, left, right);
    }
}
