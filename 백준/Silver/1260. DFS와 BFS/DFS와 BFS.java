import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }

        dfs(start);

        System.out.println();

        visited = new boolean[N + 1];

        bfs(start);

    }

    static void dfs(int num) {
        
        System.out.print(num + " ");
        visited[num] = true;

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && map[num][i] == 1) {
                dfs(i);
            }
        }
    }

    static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        visited[num] = true;
        queue.offer(num);
        sb.append(num).append(" ");
        while(!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && map[now][i] == 1) {
                    visited[i] = true;
                    queue.offer(i);
                    sb.append(i).append(" ");
                }
            }
        }
        System.out.println(sb.toString());
    }

}