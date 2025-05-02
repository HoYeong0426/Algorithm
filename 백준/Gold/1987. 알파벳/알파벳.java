import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static int max = 0;
    static Set<Character> visited = new HashSet<>();
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new char[N][K];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < K; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        visited.add(map[0][0]);
        dfs(0, 0, 1);

        System.out.println(max);

    }

    static void dfs(int x, int y, int count) {
        max = Math.max(max, count);

        for (int i = 0; i < 4; i++ ){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < map.length && nextY < map[0].length) {
                char nextChar = map[nextX][nextY];
                if(!visited.contains(nextChar)) {
                    visited.add(nextChar);
                    dfs(nextX, nextY, count + 1);
                    visited.remove(nextChar);
                }
            }
        }


    }
}