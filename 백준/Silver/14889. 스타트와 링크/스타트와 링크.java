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

        dfs(0, 0);

        System.out.println(min);

    }

    public static void dfs(int depth, int idx) {

        if (depth == n / 2) {
            int teamA = 0;
            int teamB = 0;

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (visited[i] && visited[j]) {
                        teamA += map[i][j] + map[j][i];
                    }
                    if (!visited[i] && !visited[j]) {
                        teamB += map[i][j] + map[j][i];
                    }
                }
            }

            min = Math.min(min, Math.abs(teamA - teamB));
            return;

        }

        for (int i = idx; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }


    }

}