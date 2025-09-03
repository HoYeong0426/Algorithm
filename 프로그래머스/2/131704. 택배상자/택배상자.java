import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        int delivery = 1;
        Stack<Integer> stack = new Stack<>();
        for (int num : order) {
            while (delivery <= num) {
                stack.push(delivery++);
            }

            if (delivery == num) {
                answer++;
            } else if (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}