import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int days;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        map = new int[x][y];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) queue.offer(new int[] {i, j});
            }
        }

        bfs(queue);


        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(days - 1);


    }

    static void bfs(Queue<int[]> queue) {
        days = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                int nowX = arr[0];
                int nowY = arr[1];

                for (int k = 0; k < 4; k++) {
                    int nextX = nowX + dx[k];
                    int nextY = nowY + dy[k];

                    if (nextX >= 0 && nextY >= 0 && nextX < map.length && nextY < map[0].length && map[nextX][nextY] == 0) {
                        queue.offer(new int[] {nextX, nextY});
                        map[nextX][nextY] = 1;
                    }
                }
            }

            days++;

        }

    }


}