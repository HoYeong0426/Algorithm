import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][10];
        int mod = 1_000_000_000;

        // 한 자리 수: 1~9만 가능 (0 제외)
        for (int i = 1; i <= 9; i++) {
            arr[1][i] = 1;
        }

        // DP 점화식
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j > 0) arr[i][j] = (arr[i][j] + arr[i - 1][j - 1]) % mod;
                if (j < 9) arr[i][j] = (arr[i][j] + arr[i - 1][j + 1]) % mod;
            }
        }

        int count = 0;
        for (int i = 0; i <= 9; i++) {
            count = (count + arr[n][i]) % mod;
        }

        System.out.println(count);
    }
}
