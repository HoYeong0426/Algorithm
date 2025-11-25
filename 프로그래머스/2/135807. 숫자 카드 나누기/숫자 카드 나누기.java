class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }
        
        int gcdB = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        int a = isPossible(gcdA, arrayB) ? gcdA : 0;
        int b = isPossible(gcdB, arrayA) ? gcdB : 0;
        
        return Math.max(a, b);
    }
    
    static boolean isPossible(int num, int[] others) {
        for (int other : others) {
            if (other % num == 0) return false;
        }
        return true;
    }
    
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}