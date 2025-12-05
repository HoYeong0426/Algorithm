class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1;
        int right = 0;
        for (int i = 0; i< stones.length; i++) {
            right = Math.max(right, stones[i]);
        }
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (isPossible(stones, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    static boolean isPossible(int[] stones, int k, int people) {
        int skip = 0;
        
        for (int s : stones) {
            if (s < people) {
                skip++;
                if (skip == k) return false;
            } else {
                skip = 0;
            }
        }
        return true;
    }
}