import java.util.*;

class Solution {
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<List<Integer>> map = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) map.add(new ArrayList<>());
        
        for (int[] r : roads) {
            int a = r[0];
            int b= r[1];
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[destination] = 0;
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(destination);
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : map.get(now)) {
                if (dist[next] != -1) continue;
                dist[next] = dist[now] + 1;
                queue.offer(next);
            }
        }
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
    
}