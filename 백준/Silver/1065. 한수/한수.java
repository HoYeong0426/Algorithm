import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		System.out.println(hansu(N));;

	}

	public static int hansu(int N) {
		int count = 0;

		if (N < 100) return N;

		count = 99;

		for (int i = 100; i <= N; i++) {
			int a = i / 100;
			int b = (i / 10 ) % 10;
			int c = i % 10;

			if ((b - a) == (c - b)) {
				count++;
			}
		}

		return count;
	}

}