import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minLength = Integer.MAX_VALUE;
        int start = 0, end = 0, sum = 0;

        while (true) {
            if (sum >= S) {
                minLength = Math.min(minLength, end - start);
                sum -= arr[start++];
            } else if (end == N) {
                break;
            } else {
                sum += arr[end++];
            }
        }

        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}
