class Solution {
    public int solution(int n) {
        int num = 0;
        String now = Integer.toBinaryString(n);
        int nowCnt = now.replace("0", "").length();

        while (true) {
            num++;
            
            String next = Integer.toBinaryString(n + num);
            int nextCnt = next.replace("0", "").length();

            if (nowCnt == nextCnt) break;
        }

        return n + num;
    }
}