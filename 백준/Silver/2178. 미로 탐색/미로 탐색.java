import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        map = new int[x][y];
        visited = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            String str = br.readLine();
            for (int j = 0; j < y; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        visited[0][0] = true;

        bfs(0, 0);

        System.out.println(map[x -1][y-1]);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int nowX = arr[0];
            int nowY = arr[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length) continue;
                if (visited[nextX][nextY] || map[nextX][nextY] == 0) continue;

                queue.offer(new int[] {nextX, nextY});
                visited[nextX][nextY] = true;
                map[nextX][nextY] = map[nowX][nowY] + 1;
            }
            
        }


    }

}