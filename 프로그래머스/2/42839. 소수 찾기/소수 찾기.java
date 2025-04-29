import java.util.*;
class Solution {
    
    static Set<Integer> result = new HashSet<>();
    static boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        
        dfs(numbers, "");
        
        for (int num : result) {
            if (isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    static void dfs(String numbers, String current) {
        if (!current.isEmpty()) {
            result.add(Integer.parseInt(current));
        }
        
        // if (depth == numbers.length()) return;
        
        for (int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(numbers, current + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    static boolean isPrime(int num) {
        if (num < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}