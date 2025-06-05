class Solution {
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder total = new StringBuilder();
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < t * m; i++) {
            total.append(Integer.toString(i, n).toUpperCase());
        }
        
        for (int i = 0; result.length() < t; i++) {
            if (i % m == p - 1) {
                result.append(total.charAt(i));
            }
        }
        
        return result.toString();
        
    }
}

