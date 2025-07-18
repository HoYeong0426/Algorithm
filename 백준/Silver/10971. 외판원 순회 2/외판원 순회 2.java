import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;
    

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, i, 0 , 0);
            visited[i] = false;
        }

        System.out.println(result);

    }

    public static void dfs(int start, int now, int count, int sum) {

        if (count == n - 1) {
            if (arr[now][start] != 0) {
                result = Math.min(result, sum + arr[now][start]);
            }
        }


        for (int next = 0; next < n; next++) {
            if (visited[next] || arr[now][next] == 0) continue;
            visited[next] = true;
            dfs(start, next, count + 1, sum + arr[now][next]);
            visited[next] = false;
        }

    }

}