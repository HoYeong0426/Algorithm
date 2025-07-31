import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());


		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = a; i <= b; i++) {
			if (isPrime(i)) {
				min = Math.min(min, i);
				sum += i;
			};
		}

		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}

	}

	public static boolean isPrime(int n) {
		if (n < 2) return false;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) return false;
		}

		return true;
	}
}