import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int floor = Integer.parseInt(br.readLine());
            int ho = Integer.parseInt(br.readLine());

            int[][] dp = new int[floor + 1][ho + 1];

            for (int i = 1; i <= ho; i++) {
                dp[0][i] = i;
            }

            for (int i = 1; i <= floor; i++) {
                for (int j = 1; j <= ho; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

            System.out.println(dp[floor][ho]);
        }
        
    }
}