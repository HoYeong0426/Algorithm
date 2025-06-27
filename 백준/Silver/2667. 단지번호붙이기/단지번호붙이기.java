import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    list.add(bfs(i, j));
                }
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");

        for (int num : list) {
            sb.append(num).append("\n");
        }

        System.out.println(sb.toString());

    }

    static int bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {row, col});
        visited[row][col] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int nowY = arr[0];
            int nowX = arr[1];

            for (int i = 0; i < 4; i++) {
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];
                if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= N) continue;
                if (visited[nextY][nextX] || map[nextY][nextX] != 1)  continue;

                queue.offer(new int[] {nextY, nextX});
                visited[nextY][nextX] = true;
                count++;
            }
        }

        return count;
    }


}