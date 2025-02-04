import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<Integer>[] tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        
        int[] parent = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int child : tree[current]) {
                if (!visited[child]) {
                    visited[child] = true;
                    parent[child] = current;
                    queue.offer(child);
                }
            }
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 2; i <= N; i++) {
            bw.write(parent[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
