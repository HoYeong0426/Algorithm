import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < N; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            visited = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }

            boolean result = true;
            for (int i = 1; i <= V; i++) {
                if (visited[i] == 0) {
                    if(!isPossible(i)) {
                        result = false;
                        break;
                    }
                }
            }

            sb.append(result ? "YES" : "NO").append("\n");

        }

        System.out.println(sb.toString());

    }

    static boolean isPossible(int target) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(target);
        visited[target] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph[now]) {
                
                if (visited[next] == 0) {
                    queue.offer(next);
                    visited[next] = -visited[now];
                } else if (visited[next] == visited[now]) {
                    return false;
                }
            }
        }
        return true;
    }


}