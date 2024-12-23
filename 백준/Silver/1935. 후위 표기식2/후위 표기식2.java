import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String alphabet = br.readLine();

        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < alphabet.length(); i++) {
            char ch = alphabet.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                double result = arr[ch - 'A'];
                stack.push(result);
            } else {
                double after = stack.pop();
                double before = stack.pop();
                double result = 0;
                switch (ch) {
                    case '+': result = before + after; break;
                    case '-': result = before - after; break;
                    case '*': result = before * after; break;
                    case '/': result = before / after; break;
                }
                stack.push(result);
            }
        }

        bw.write(String.format("%.2f", stack.pop()));
        br.close();
        bw.close();

    }
}