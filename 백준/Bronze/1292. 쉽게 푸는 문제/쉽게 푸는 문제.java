import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[] arr = new int[1001]; // b는 최대 1000
		int index = 1;
		int num = 1;

		while (index <= 1000) {
			for (int i = 0; i < num && index <= 1000; i++) {
				arr[index++] = num;
			}
			num++;
		}

		int sum = 0;
		for (int i = a; i <= b; i++) {
			sum += arr[i];
		}

		System.out.println(sum);
	}
}