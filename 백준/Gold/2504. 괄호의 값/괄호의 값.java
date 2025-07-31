import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		Stack<Object> stack = new Stack<>();
		for (char ch : str.toCharArray()) {

			if (ch == '(' || ch == '[') {
				stack.push(ch);
			} else {
				int sum = 0;

				while (!stack.isEmpty() && stack.peek() instanceof Integer) {
					sum += (int) stack.pop();
				}

				if (stack.isEmpty()) {
					System.out.println(0);
					return;
				}

				char before = (char) stack.pop();
				if (before == '(' && ch == ')') {
					stack.push(sum == 0 ? 2 : sum * 2);
				} else if (before == '[' && ch == ']') {
					stack.push(sum == 0 ? 3 : sum * 3);
				} else {
					System.out.println(0);
					return;
				}

			}
		}

		int result = 0;
		for (Object o : stack) {
			if (o instanceof Character) {
				System.out.println(0);
				return;
			}
			result += (int) o;
		}

		System.out.println(result);

	}
}