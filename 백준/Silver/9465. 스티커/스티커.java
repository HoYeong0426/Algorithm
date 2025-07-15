import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            int num = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][num + 1];
            int[][] dp = new int[2][num + 1];

            for (int k = 0; k < 2; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= num; j++) {
                    arr[k][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for (int k = 2; k <= num; k++) {
                dp[0][k] = Math.max(dp[1][k - 1], dp[1][k - 2]) + arr[0][k];
                dp[1][k] = Math.max(dp[0][k - 1], dp[0][k - 2]) + arr[1][k];
            }

            System.out.println(Math.max(dp[0][num], dp[1][num]));

        }

    }

}