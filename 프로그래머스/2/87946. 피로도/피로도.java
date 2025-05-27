import java.util.*;
class Solution {
    
    static int max = 0;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, 0);
        
        return max;
    }
    
    static void dfs(int k, int[][] dungeons, int count) {
        max = Math.max(max, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            int a = dungeons[i][0];
            int b = dungeons[i][1];
            
            if (!visited[i] && k >= a) {
                visited[i] = true;
                dfs(k - b, dungeons, count + 1);
                visited[i] = false;
                
            }
            
        }
    }
    
    
}