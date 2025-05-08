import java.util.*;

public class Main {
    static int N;
    static int[] A;
    static boolean[] visited;
    static int[] perm;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        visited = new boolean[N];
        perm = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        dfs(0);
        System.out.println(max);
    }

    static void dfs(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(perm[i] - perm[i + 1]);
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm[depth] = A[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
