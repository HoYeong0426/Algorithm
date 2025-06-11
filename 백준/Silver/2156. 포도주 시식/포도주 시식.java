import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] wines = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(wines[0]);
            return;
        }

        if (N == 2) {
            System.out.println(wines[0] + wines[1]);
            return;
        }

        dp[0] = wines[0];
        dp[1] = wines[0] + wines[1];
        dp[2] = Math.max(
            Math.max(wines[0] + wines[2], wines[1] + wines[2]),
            dp[1]
        );

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(
                Math.max(dp[i - 1], dp[i - 2] + wines[i]),
                dp[i - 3] + wines[i - 1] + wines[i]
            );
        }

        System.out.println(dp[N - 1]);
    }
}
