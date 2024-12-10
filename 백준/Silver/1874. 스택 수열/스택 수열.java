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

		
		int count = Integer.parseInt(br.readLine());
		int[] arr = new int[count];
		for(int i = 0; i < count; i++) arr[i] = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		int num = 1;
		for(int i = 0; i < count; i++) {
			
			while(num <= arr[i]) {
				stack.push(num);
				sb.append("+").append("\n");
				num++;
			}

			if(stack.peek() == arr[i]) {
				stack.pop();
				sb.append("-").append("\n");
			} else {
				sb = new StringBuilder();
				sb.append("NO");
				break;
			}

		}

		bw.write(sb.toString());
		

		br.close();
		bw.close();
        
    }

}