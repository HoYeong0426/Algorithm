import java.util.*;
class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] arr = s.split("\\},\\{");
        
        Arrays.sort(arr, Comparator.comparing(i -> i.length()));        
        
        List<Integer> list = new ArrayList<>();
        
        for(String str : arr) {
            String[] arr2 = str.split(",");
            
            for (String val : arr2) {
                int value = Integer.parseInt(val);
                if (!list.contains(value)) {
                    list.add(value);
                }
            }
            
        }
        
        
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}