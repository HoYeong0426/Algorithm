import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[] { a, 1 });
            list.add(new int[] { b, -1 });
        }

        list.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int count = 0;
        int result = 0;
        for (int[] arr : list) {
            count += arr[1];
            result = Math.max(result, count);
        }

        System.out.println(result);

    }
}