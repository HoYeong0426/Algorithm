import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        int[] dp = new int[N];


        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (numbers[i] > numbers[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }


        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);

    }

}