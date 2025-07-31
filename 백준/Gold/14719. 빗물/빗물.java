import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[] height = new int[w];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < w; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;
		for (int i = 1; i < w -1; i++) {
			int left = 0;
			int right = 0;

			for (int j = 0; j < i; j++) {
				left = Math.max(left, height[j]);
			}

			for (int k = i; k < w; k++) {
				right = Math.max(right, height[k]);
			}

		int count = Math.min(left, right) - height[i];
		if (count > 0) result += count;

		}

		System.out.println(result);

	}
}