import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = new int[N][N];
        visited = new boolean[N];

        // 능력치 행렬 입력
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                S[i][j] = sc.nextInt();

        dfs(0, 0);

        System.out.println(min);
    }

    static void dfs(int depth, int idx) {
        if (depth == N / 2) {
            calcDiff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    static void calcDiff() {
        int start = 0, link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    start += S[i][j] + S[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += S[i][j] + S[j][i];
                }
            }
        }

        min = Math.min(min, Math.abs(start - link));
    }
}
