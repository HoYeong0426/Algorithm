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
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            map = new int[x][y];
            visited = new boolean[x][y];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                map[a][b] = 1;
            }

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
            count = 0;

        }

    }


    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
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

            }

        }
    }

}