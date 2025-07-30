import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int x, y;
	static int max = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = new int[] {-1, 1, 0, 0};
	static int[] dy = new int[] {0, 0, -1, 1};


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		map = new int[y][x];
		visited = new boolean[y][x];

		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < x; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, map[i][j]);
				visited[i][j] = false;
			}
		}
		
		System.out.println(max);

	}

	public static void dfs(int row, int col, int count, int sum) {

		if (count == 4) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < 4; i++){
			int nextY = row + dy[i];
			int nextX = col + dx[i];

			if (nextY < 0 || nextX < 0 || nextY >= y || nextX >= x) continue;
			if (visited[nextY][nextX]) continue;

			if (count == 2) {
				visited[nextY][nextX] = true;
				dfs(row, col, count + 1, sum + map[nextY][nextX]);
				visited[nextY][nextX] = false;
			}

			visited[nextY][nextX] = true;
			dfs(nextY, nextX, count + 1, sum + map[nextY][nextX]);
			visited[nextY][nextX] = false;

		}
	}
	
}