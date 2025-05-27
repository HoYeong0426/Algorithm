import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());

		int min = Integer.MAX_VALUE;

		String[][] map = new String[row][col];

		for (int i = 0; i < row; i++) {
			String str = br.readLine();
			for (int j = 0; j < col; j++) {
				map[i][j] = str.charAt(j) + "";
			}
		}

		for (int i = 0; i < row - 7; i++) {
			for (int j = 0; j < col - 7; j++) {
				min = Math.min(min, result(i, j, map));
			}
		}

		System.out.println(min);

	}

	static int result(int i, int j, String[][] map) {

		String color = "W";
		int count = 0;

		for (int row = i; row < i + 8; row++) {
			for (int col = j; col < j + 8; col++) {

				if (color.equals(map[row][col])) {
					count++;
				}

				color = color.equals("W") ? "B" :"W";
			}

			color = color.equals("W") ? "B" :"W";
		}

		return Math.min(count, 64 - count);
	}
}