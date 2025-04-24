import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        int MOD = 1_000_000_007;

        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }
        
        dp[1][1] = 1;

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {

                if (dp[y][x] == -1) {
                    dp[y][x] = 0;
                    continue;
                }

                if (y > 1) dp[y][x] = (dp[y][x] + dp[y - 1][x]) % MOD;
                if (x > 1) dp[y][x] = (dp[y][x] + dp[y][x - 1]) % MOD;
            }
        }

        return dp[n][m];
    }
}