import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());

            int[] result = dynamic(k);

            sb.append(result[0] + " ").append(result[1]).append("\n");
        }

        System.out.println(sb.toString());

    }

    public static int[] dynamic(int k) {
        if (k == 0) return new int[] {1, 0};
        if (k == 1) return new int[] {0, 1};

        int[][] dp = new int[k + 1][2];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= k; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        return dp[k];
    }


}