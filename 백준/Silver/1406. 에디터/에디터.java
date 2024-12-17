import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }

        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i ++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "L":
                    if (!left.isEmpty()) right.push(left.pop());
                    break;
                case "D":
                    if (!right.isEmpty()) left.push(right.pop());
                    break;
                case "B":
                    if (!left.isEmpty()) left.pop();
                    break;
                default:
                    left.push(st.nextToken().toCharArray()[0]);
                    break;
            }
        }

        while(!left.isEmpty()) {
            right.push(left.pop());
        }

        while(!right.isEmpty()) {
            sb.append(right.pop());
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
        
    }

}