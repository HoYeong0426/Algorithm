import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int M = Integer.parseInt(br.readLine());

            int[][] arr = new int[M][2];

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, (o1,o2) -> o1[0] - o2[0]);

            int count = 1;
            int other = arr[0][1];

            for (int i = 1; i < M; i ++) {
                if (arr[i][1] < other) {
                    count++;
                    other = arr[i][1];
                }
            }

            System.out.println(count);

        }

    }
}