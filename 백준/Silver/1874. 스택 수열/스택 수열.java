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
            int now = arr[i];

            if (now >= num) {
                while (now >= num) {
                    stack.push(num++);
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
            } else {
                int pop = stack.pop();
                if (pop == now) {
                    sb.append("-").append("\n");
                } else {
                    System.out.println("NO");
                    return;
                }
            }

        }

        System.out.println(sb.toString());

    }
}