import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int row, col;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        List<Integer> result = new ArrayList<>();

        map = new int[row][col];
        visited = new boolean[row][col];

        for (int i = 0 ; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int col1 = Integer.parseInt(st.nextToken());
            int row1 = Integer.parseInt(st.nextToken());
            int col2 = Integer.parseInt(st.nextToken());
            int row2 = Integer.parseInt(st.nextToken());

            for (int j = row1; j < row2; j++) {
                for (int k = col1; k < col2; k++ ) {
                    map[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && map[i][j] != 1) {
                    result.add(bfs(i, j));
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for (int N : result) {
            System.out.print(N + " ");
        }

    }


    static int bfs(int y, int x) {
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

                if (nextX < 0 || nextY < 0 || nextY >= row || nextX >= col) continue;
                if (visited[nextY][nextX] || map[nextY][nextX] == 1) continue;

                queue.offer(new int[] {nextY, nextX});
                visited[nextY][nextX] = true;
                count++;
                
            }
        }

        return count;

    }


}