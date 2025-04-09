import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = new int[] {-1, 1, 0 , 0};
    static int[] dy = new int[] {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        
        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        int result = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                minHeight = Math.min(minHeight, num);
                maxHeight = Math.max(maxHeight, num);
            }
        }

        for (int k = 0; k <= maxHeight; k++) {
            visited = new boolean[N][N];
            count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > k) {
                        bfs(i, j, k);
                        count++;
                    }
                }
            }

            result = Math.max(result, count);
        }

        System.out.println(result);

        
    }


    static void bfs(int x, int y, int height) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int nowX = arr[0];
            int nowY = arr[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
    
                if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map.length) continue;
                if (visited[nextX][nextY] || map[nextX][nextY] <= height) continue;

                queue.add(new int[] {nextX, nextY});
                visited[nextX][nextY] = true;
    
            }
        }
    }


}