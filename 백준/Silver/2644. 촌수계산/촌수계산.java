import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int max, start, end, count = 0, result = -1;
    static boolean[] visited;
    static int[][] graph;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        max = Integer.parseInt(br.readLine());
        visited = new boolean[max + 1];
        graph = new int[max + 1][max + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(start);

        System.out.println(result);

    }

    static void dfs(int node) {
        if (node == end) { 
            result = count;
            return;
        }

        visited[node] = true;

        for (int i = 1; i <= max; i++) {
            if(!visited[i] && graph[node][i] == 1) {
                count++;
                dfs(i);
                count--;
            }
        }


    }

}
