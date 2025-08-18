import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        long left = 1;
        long right = 0;
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }


        long result = 0;
        while (left <= right) {
            long mid = (left + right) / 2;

            if (isPossible(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);

    }

    public static boolean isPossible(long target) {

        int count = 0;
        for (int i = 0; i < N; i++) {
            count += arr[i] / target;
        }

        return count >= M;
    }

}
