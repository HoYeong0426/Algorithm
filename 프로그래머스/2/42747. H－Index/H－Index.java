import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for (int i = 0; i < citations.length; i++) {
            int upper = citations.length - i;
            
            if (citations[i] >= upper) {
                return upper;
            }
        }
        
        return 0;
    }
}