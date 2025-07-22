import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        visited = new boolean[n + 1];

        bfs(1);

    }

    public static void bfs(int count) {
        if (count == n + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n ; i++) {
                sb.append(arr[i] + " ");
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[count] = i;
            bfs(count + 1);
            visited[i] = false;
        }
    }

}