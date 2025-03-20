import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        System.out.println(bfs(N, K));
    }
    
    static int bfs(int start, int target) {
        if (start == target) return 0;
        
        int[] visited = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(start);
        visited[start] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : new int[]{current - 1, current + 1, current * 2}) {
                if (next >= 0 && next <= 100000 && visited[next] == 0) {
                    visited[next] = visited[current] + 1;
                    queue.offer(next);
                    
                    if (next == target) return visited[next];
                }
            }
        }
        
        return -1;
    }
}