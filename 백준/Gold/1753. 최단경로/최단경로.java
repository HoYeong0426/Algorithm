import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int vertex, weight;
    
    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.weight, other.weight);
    }
}

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> graph;
    static int[] dist;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<>();
        dist = new int[V + 1];
        visited = new boolean[V + 1];
        
        Arrays.fill(dist, INF);
        
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }
        
        dijkstra(K);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(dist[i] == INF ? "INF" : dist[i]).append("\n");
        }
        System.out.print(sb);
    }
    
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curVertex = current.vertex;
            
            if (visited[curVertex]) continue;
            visited[curVertex] = true;
            
            for (Node neighbor : graph.get(curVertex)) {
                if (dist[neighbor.vertex] > dist[curVertex] + neighbor.weight) {
                    dist[neighbor.vertex] = dist[curVertex] + neighbor.weight;
                    pq.offer(new Node(neighbor.vertex, dist[neighbor.vertex]));
                }
            }
        }
    }
}
