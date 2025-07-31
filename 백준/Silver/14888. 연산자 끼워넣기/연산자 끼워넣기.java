import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] number, operator;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		number = new int[n];
		operator = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		dfs(1, number[0]);

		System.out.println(max);
		System.out.println(min);

	}


	public static void dfs(int idx, int sum) {

		if (idx == n) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] == 0) continue;

			int now = number[idx];
			operator[i] -= 1;
			switch (i) {
				case 0: dfs(idx + 1, sum + now); break;
				case 1: dfs(idx + 1, sum - now); break;
				case 2: dfs(idx + 1, sum * now); break;
				default: dfs(idx + 1, sum / now); break;
			}
			operator[i] += 1;
		}

	}

}