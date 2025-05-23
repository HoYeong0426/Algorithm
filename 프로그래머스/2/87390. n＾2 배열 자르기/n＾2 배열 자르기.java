import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        
        long length = right - left + 1;
        int[] answer = new int[(int)length];
        
        for (int i = 0; i < length; i++) {
            
            long row = (left + i) / n;
            long col = (left + i) % n;
            
            answer[i] = (int) (Math.max(row, col) + 1);
        }

        return answer;
    }
}