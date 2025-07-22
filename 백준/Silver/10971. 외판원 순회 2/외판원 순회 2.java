import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            bfs(i, 0, 0, i);
            visited[i] = false;
        }

        System.out.println(min);

    }

    public static void bfs(int idx, int count, int sum, int start) {

        if (count == n - 1) {
            if (map[idx][start] != 0) {
                min = Math.min(min, sum + map[idx][start]);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] || map[idx][i] == 0) continue;
            visited[i] = true;
            bfs(i, count + 1, sum + map[idx][i], start);
            visited[i] = false;
        }

    }

}