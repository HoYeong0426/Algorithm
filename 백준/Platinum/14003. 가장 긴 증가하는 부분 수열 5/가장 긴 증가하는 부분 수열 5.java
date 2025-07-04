import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] pos = new int[n];
        int[] prev = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prev[i] = -1;
        }

        List<Integer> list = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int idx = binarySearch(list, arr[i]);
            if (idx == list.size()) {
                list.add(arr[i]);
                indexList.add(i);
            } else {
                list.set(idx, arr[i]);
                indexList.set(idx, i);
            }

            pos[i] = idx;
            if (idx > 0) {
                prev[i] = indexList.get(idx - 1);
            }
        }

        Stack<Integer> stack = new Stack<>();
        int len = list.size();
        System.out.println(len);

        int cur = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (pos[i] == len - 1) {
                cur = i;
                break;
            }
        }

        while (cur != -1) {
            stack.push(arr[cur]);
            cur = prev[cur];
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
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
