import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {
			int n = Integer.parseInt(br.readLine());

			String[] binary = Integer.toBinaryString(n).split("");
			int count = binary.length - 1;

			for (int j = count; j >= 0; j--) {
				if ("1".equals(binary[j])) System.out.print(count - j + " ");
			}

		}


    }

}