import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        String str = br.readLine();
        boolean check = false;

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '<':
                    while(!stack.isEmpty()) sb.append(stack.pop());
                    sb.append(str.charAt(i));
                    check = true;
                    break;
                case '>':
                    sb.append(str.charAt(i));
                    check = false;
                    break;
                case ' ':
                    while(!stack.isEmpty()) sb.append(stack.pop());
                    sb.append(str.charAt(i));
                    break;
                default:
                    if (check) {
                        sb.append(str.charAt(i));
                    } else {
                        stack.push(str.charAt(i));
                    }
                    break;
            }
        }

        while(!stack.isEmpty()) sb.append(stack.pop());


        bw.write(sb.toString());
        bw.close();
        br.close();
        
    }

}