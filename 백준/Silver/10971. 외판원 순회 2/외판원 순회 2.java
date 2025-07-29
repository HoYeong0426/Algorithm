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
            dfs(0, i, i, 0);
            visited[i] = false;
        }

        System.out.println(min);

    }

    public static void dfs(int depth, int idx, int first, int sum) {
        if (depth == n - 1) {
            if (map[idx][first] != 0) {
                min = Math.min(min, sum + map[idx][first]);
                return;
            }
            
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] || map[idx][i] == 0) continue;
            visited[i] = true;
            dfs(depth + 1, i, first, sum + map[idx][i]);
            visited[i] = false;
        }

    }

}