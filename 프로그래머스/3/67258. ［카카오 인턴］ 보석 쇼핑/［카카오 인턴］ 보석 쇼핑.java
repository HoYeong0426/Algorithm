import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        Set<String> set = new HashSet<>();
        
        for (String gem : gems) set.add(gem);
        int kind = set.size();
        
        Map<String, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < gems.length) {
            String gem = gems[right];
            map.put(gem, map.getOrDefault(gem, 0) + 1);
            
            while (kind == map.size()) {
                if (minLen > right - left) {
                    minLen = right - left;
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }
                
                String leftGem = gems[left];
                map.put(leftGem, map.get(leftGem) - 1);
                if (map.get(leftGem) == 0) map.remove(gems[left]);
                left++;
            }
            right++;
            
        }
        
        return answer;
    }
    
    
}