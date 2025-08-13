import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		long maxTime = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			maxTime = Math.max(maxTime, arr[i]);
		}

		long left = 1;
		long right = maxTime * M;
		long answer = right;
		while (left <= right) {
			long mid = (left + right) / 2;
			long count = 0;

			for (int i = 0; i < N; i++) {
				count += mid / arr[i];
                if (count >= M) break;
			}

			if (count >= M) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}

		System.out.println(answer);

	}

}