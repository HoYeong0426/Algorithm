class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int range = w * 2 + 1;
        int start = 1;
        
        for (int station : stations) {
            int left = station - w;
            int right = station + w;
            
            if (left > start) {
                int gap = left - start;
                answer += Math.ceil((double)gap / range);
            }
            start = right + 1;
        }
        
        
        if (start <= n) {
            int gap = n - start + 1;
            answer += Math.ceil((double)gap / range);
        }

        return answer;
    }
}