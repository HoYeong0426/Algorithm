import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        StringBuilder sb = new StringBuilder();
        boolean[] prime = getPrimes(M);
        for (int i = N; i <= M; i++) {
            if (prime[i]) continue;
            sb.append(i + "\n");
        }

        System.out.println(sb.toString());

    }

    static boolean[] getPrimes(int target) {
        boolean[] prime = new boolean[target + 1];

        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(target); i++) {
            if (prime[i]) continue;
            for (int j = i * i; j <= target; j += i) {
                prime[j] = true;
            }
        }

        return prime;

    }

}