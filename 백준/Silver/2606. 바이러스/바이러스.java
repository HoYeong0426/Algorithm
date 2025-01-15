import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int result;
	static int[][] arr;
	static boolean[] visited;
	static int computer;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		computer = Integer.parseInt(br.readLine());
		int count = Integer.parseInt(br.readLine());

		arr = new int[computer + 1][computer + 1];
		visited = new boolean[computer + 1];

		StringTokenizer st;
		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		bfs(1);

		System.out.println(result);
	}


	public static void bfs(int n) {
		visited[n] = true;

		for (int i = 1; i < computer + 1; i++) {
			if (arr[n][i] == 1 && visited[i] == false) {
				bfs(i);
				result++;
			}
		}

	}

}