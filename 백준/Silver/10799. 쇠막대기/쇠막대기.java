import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();

        String str = br.readLine();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '(':
                    stack.push(str.charAt(i));
                    break;
                case ')':
                    if (str.charAt(i - 1) == '(') {
                        stack.pop();
                        count += stack.size();
                    } else {
                        stack.pop();
                        count += 1;
                    }
                    break;
            }
        }

        System.out.println(count);
        br.close();
        
    }

}