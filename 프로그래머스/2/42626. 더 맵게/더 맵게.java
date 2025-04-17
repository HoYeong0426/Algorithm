import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        while (pq.peek() < K) {
            int A = pq.poll();
            if (pq.isEmpty()) return -1;
            int B = pq.poll();
            pq.offer(A + B * 2);
            answer++;
        }
        
        
        return answer;
    }
}