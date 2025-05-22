import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];

        for (int i = 0 ; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }

        visited = new boolean[N + 1];
        dfs(start);
        
        System.out.println();

        visited = new boolean[N + 1];
        bfs(start);

    }

    static void dfs(int start) {
        System.out.print(start + " ");
        visited[start] = true;

        for (int i = 0; i < map.length; i++) {
            if (map[start][i] != 1 || visited[i]) continue;
            dfs(i);
        }

    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < map.length; i++) {
                if (map[now][i] != 1 || visited[i]) continue;
                visited[i] = true;
                queue.offer(i);
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString());
    }

}