import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int score[][] = new int[N + 1][N + 1];
        int dp[][] = new int[N + 1][N + 1];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            score[i][0] = Integer.parseInt(st.nextToken());
            score[i][1] = Integer.parseInt(st.nextToken());
            score[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = score[0][0];
        dp[0][1] = score[0][1];
        dp[0][2] = score[0][2];

        for (int i = 1; i <= N; i ++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + score[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + score[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + score[i][2];
        }

        System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));

    }
}