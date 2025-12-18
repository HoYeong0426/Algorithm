import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < enemy.length; i++) {
            
            pq.offer(enemy[i]);
            n -= enemy[i];
            
            if (n < 0) {
                if (k > 0) {
                    k--;
                    n += pq.poll();
                } else {
                    break;
                }
            }
            
            
            
            answer++;
        }
        
        
        return answer;
    }
}