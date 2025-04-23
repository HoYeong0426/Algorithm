import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            Arrays.sort(arr);
            long next = arr[0] + arr[1];
            arr[0] = next;
            arr[1] = next;
        }

        long result = 0;
        for (int i = 0; i < N; i++) {
            result += arr[i];
        }

        System.out.println(result);

    }



}