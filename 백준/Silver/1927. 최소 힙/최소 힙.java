import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int count = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < count; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				sb.append(queue.isEmpty() ? 0 : queue.poll()).append("\n");
			} else {
				queue.offer(num);
			}
			
		}

		System.out.println(sb.toString());

	}
}