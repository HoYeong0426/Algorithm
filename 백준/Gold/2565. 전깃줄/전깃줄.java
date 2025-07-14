import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] line = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int idx = binarySearch(list, line[i][1]);

            if (idx == list.size()) {
                list.add(line[i][1]);
            } else {
                list.set(idx, line[i][1]);
            }
        }

        System.out.println(n - list.size());


    }

    static int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


}
