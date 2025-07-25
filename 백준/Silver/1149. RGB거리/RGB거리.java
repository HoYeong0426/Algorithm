import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] score = new int[n][3];
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            score[i][0] = Integer.parseInt(st.nextToken());
            score[i][1] = Integer.parseInt(st.nextToken());
            score[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = score[0][0];
        dp[0][1] = score[0][1];
        dp[0][2] = score[0][2];


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + score[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + score[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + score[i][2];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(dp[n - 1][i], min);
        }

        System.out.println(min);

    }

}