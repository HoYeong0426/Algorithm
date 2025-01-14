import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());


        arr = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        visited = new boolean[N+1];

        dfs(V);

        System.out.println();

        visited = new boolean[N + 1];

        bfs(V);

        System.out.println();

        
    }

    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        if (v == arr.length) return;

        for (int i = 1; i < arr.length; i++) {
            if (arr[v][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }

    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        System.out.print(v + " ");

        while(!queue.isEmpty()) {
            int n = queue.poll();

            for (int i = 1; i < arr.length; i++) {
                if (arr[n][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    System.out.print(i + " ");
                    queue.offer(i);
                }
            }
        }

    }



}