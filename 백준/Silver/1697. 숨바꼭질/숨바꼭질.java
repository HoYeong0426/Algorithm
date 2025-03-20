import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(bfs(a, b));
    }


    static int bfs(int a, int b) {
        if (a == b) return 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);

        int[] visited = new int[100001];

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : new int[] {now - 1, now + 1, now * 2}) {
                if (next >= 0 && next <= 100000 && visited[next] == 0) {
                    queue.offer(next);
                    visited[next] = visited[now] + 1;
                    if (next == b) return visited[next];
                }

            }
            
        }

        return -1;
    }
    
}