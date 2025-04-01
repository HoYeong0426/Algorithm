import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] dp = new int[K + 1];
        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            int coin = Integer.parseInt(br.readLine());

            for (int j = coin; j <= K; j++) {
                dp[j] += dp[j - coin];
            }
        }

        System.out.println(dp[K]);
    }
}