import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int length = elements.length;
        
        int[] extend = new int[length * 2];
        
        for (int i = 0; i < length * 2; i++) {
            extend[i] = elements[i % length];
        }
        
        for (int i = 0; i < length; i++) {
            int sum = 0;
            
            for (int j = 0; j < length; j++) {
                sum += extend[i + j];
                set.add(sum);
            }
        }
        
        

        return set.size();
    }
}