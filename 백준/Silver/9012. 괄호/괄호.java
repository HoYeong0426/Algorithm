import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Main {
 
 
	public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();

            boolean success = true;

            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        success = false;
                        break;
                    }
                    stack.pop();
                }
            }

            System.out.println(success && stack.isEmpty() ? "YES" : "NO");
        }
		
	}
 
}