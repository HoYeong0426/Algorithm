import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
        int currentDay = (int) Math.ceil((100.0 - progresses[0]) / speeds[0]);
        int count = 1;
        
        for (int i = 1; i < progresses.length; i++) {
            int now = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            
            if (currentDay >= now) {
                count++;
            } else {
                list.add(count);
                count = 1;
                currentDay = now;
            }
        }
        
        list.add(count);
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}
