import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static ArrayList<Integer>[] graph;
	static boolean[] visited;

    public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}


		int count = 0;

		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i);
				count++;
			}
		}

		System.out.println(count);
		br.close();
    }

	static void dfs(int node) {
		visited[node] = true;
		for (int num : graph[node]) {
			if (!visited[num]) {
				dfs(num);
			}
		}

	}

}