import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[46];

        System.out.println(dp(N));

    }

    static int dp(int N) {
        if (N < 2) return N;

        if (arr[N] != 0) return arr[N];

        return arr[N] = dp(N - 1) + dp(N - 2);
    }


}