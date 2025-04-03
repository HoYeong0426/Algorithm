import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int city, cost;
        Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(from).add(new Node(to, cost));
        }
        
        int start = sc.nextInt();
        int end = sc.nextInt();
        sc.close();
        
        System.out.println(dijkstra(n, graph, start, end));
    }
    
    static int dijkstra(int n, List<List<Node>> graph, int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.city;
            int nowCost = current.cost;
            
            if (dist[now] < nowCost) continue;
            
            for (Node next : graph.get(now)) {
                int newCost = nowCost + next.cost;
                if (newCost < dist[next.city]) {
                    dist[next.city] = newCost;
                    pq.offer(new Node(next.city, newCost));
                }
            }
        }
        return dist[end];
    }
}
