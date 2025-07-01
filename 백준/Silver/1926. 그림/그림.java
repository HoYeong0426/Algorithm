import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int row, col;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        // 6 5
        // 1 1 0 1 1
        // 0 1 1 0 0
        // 0 0 0 0 0
        // 1 0 1 1 1
        // 0 0 1 1 1
        // 0 0 1 1 1

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        visited = new boolean[row][col];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    pq.add(bfs(i, j));
                }
            }
        }

        System.out.println(pq.size());
        System.out.println(pq.isEmpty() ? 0 : pq.poll());

    }

    public static int bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {y, x});
        visited[y][x] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int nowY = arr[0];
            int nowX = arr[1];

            for (int i = 0; i < 4; i++) {
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];
                if (nextY < 0 || nextX < 0 || nextX >= col || nextY >= row) continue;
                if (visited[nextY][nextX] || map[nextY][nextX] != 1) continue;

                queue.offer(new int[] {nextY, nextX});
                visited[nextY][nextX] = true;
                count++;
            }
        }

        return count;
    }


}