import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int col, row;
    static int[][] map;
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};
 
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) queue.offer(new int[] {i, j});
            }
        }

        int days = bfs(queue);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(days - 1);

    }

    static int bfs(Queue<int[]> queue) {
        int days = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                int nowY = arr[0];
                int nowX = arr[1];

                for (int j = 0; j < 4; j++) {
                    int nextY = nowY + dy[j];
                    int nextX = nowX + dx[j];

                    if (nextY < 0 || nextX < 0 || nextY >= row || nextX >= col) continue;
                    if (map[nextY][nextX] != 0) continue;

                    queue.offer(new int[] {nextY, nextX});
                    map[nextY][nextX] = map[nowY][nowX] + 1;
                }
            }
            days++;
        }

        return days;
    }

}