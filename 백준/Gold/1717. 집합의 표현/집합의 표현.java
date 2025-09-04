import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (flag == 0) {
                union(a, b);
            } else {
                sb.append(find(a) == find(b) ? "YES" : "NO").append("\n");
            }

        }

        System.out.println(sb.toString());

    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        parent[rootA] = rootB;
    }

    static int find(int target) {
        if (parent[target] == target) {
            return target;
        }
        return parent[target] = find(parent[target]);
    }

}