import java.util.*;
class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if  (!visited[i]) {
                bfs(computers, i, n);
                answer++;
            }
        }
        
        
        return answer;
    }
    
    static void bfs(int[][] computers, int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int i = 0; i < n; i++) {
                if (!visited[i] && computers[now][i] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}