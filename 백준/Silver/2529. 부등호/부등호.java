import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String[] arr;
    static boolean[] visited;
    static int n;
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new String[n + 1]; // 부등호는 arr[1]부터 사용
        visited = new boolean[10];

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < str.length; i++) {
            arr[i + 1] = str[i];
        }

        dfs(0, new int[n + 1]);

        System.out.printf("%0" + (n + 1) + "d\n", max);
        System.out.printf("%0" + (n + 1) + "d\n", min);
    }

    public static void dfs(int count, int[] numbers) {
        if (count == n + 1) {
            StringBuilder sb = new StringBuilder();
            for (int num : numbers) {
                sb.append(num);
            }
            long value = Long.parseLong(sb.toString());
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i]) continue;

            if (count == 0 || (
                "<".equals(arr[count]) && numbers[count - 1] < i
            ) || (
                ">".equals(arr[count]) && numbers[count - 1] > i
            )) {
                numbers[count] = i;
                visited[i] = true;
                dfs(count + 1, numbers);
                visited[i] = false;
            }
        }
    }
}