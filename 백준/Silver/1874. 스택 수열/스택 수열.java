import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int num = 1;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {

            while (num <= arr[i]) {
                stack.push(num++);
                sb.append("+\n");
            }

            if (stack.pop() == arr[i]) {
                sb.append("-\n");
            } else {
                sb = new StringBuilder();
                sb.append("NO");
                break;
            }

        }

        System.out.println(sb.toString());

    }
}