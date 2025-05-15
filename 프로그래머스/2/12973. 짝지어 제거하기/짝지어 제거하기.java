import java.util.*;
class Solution {
    public int solution(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (stack.size() < 1) {
                stack.push(ch);
                continue;
            }
            
            if (stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
            
        }

         int answer = stack.size() == 0 ? 1 : 0;
        
        return answer;
    }
}