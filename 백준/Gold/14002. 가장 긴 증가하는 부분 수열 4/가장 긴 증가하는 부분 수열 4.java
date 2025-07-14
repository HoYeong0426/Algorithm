import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] prev = new int[n];
        List<Integer> list = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prev[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int idx = binarySearch(list, arr[i]);

            if (idx == list.size()) {
                list.add(arr[i]);
                indexList.add(i);
            } else {
                list.set(idx, arr[i]);
                indexList.set(idx, i);
            }

            if (idx > 0) {
                prev[i] = indexList.get(idx - 1);
            }
        }


        int lastIndex = indexList.get(indexList.size() - 1);
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[lastIndex]);
        while (prev[lastIndex] != -1) {
            lastIndex = prev[lastIndex];
            stack.push(arr[lastIndex]);
        }

        System.out.println(stack.size());
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