import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);

        int count = 1;
        int endTime = arr[0][1];
        for (int i = 1; i < n; i++) {
            if (endTime > arr[i][0]) continue;
            endTime = arr[i][1];
            count++;
        }

        System.out.println(count);

    }


}