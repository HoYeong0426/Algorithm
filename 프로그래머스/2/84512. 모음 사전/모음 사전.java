class Solution {
    public int solution(String word) {
        int answer = 0;
        
        int[] weight = new int[] {781, 156, 31, 6, 1};
        char[] vowels = new char[] {'A', 'E', 'I', 'O', 'U'};
        
        for (int i = 0; i < word.length(); i++) {
            char now = word.charAt(i);
            
            for (int j = 0; j < vowels.length; j++) {
                if (vowels[j] == now) {        
                    answer += j * weight[i] + 1;
                    break;
                }
            }
            
        }
        
        return answer;
    }
}