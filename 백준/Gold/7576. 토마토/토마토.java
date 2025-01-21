import java.util.*;

public class Main {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] box = new int[N][M];

        Queue<int[]> queue = new LinkedList<>();
        int emptyCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = sc.nextInt();
                if (box[i][j] == 1) {
                    queue.add(new int[]{i, j});
                } else if (box[i][j] == -1) {
                    emptyCount++;
                }
            }
        }

        if (queue.size() + emptyCount == N * M) {
            System.out.println(0);
            return;
        }

        int days = bfs(box, queue, N, M);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(days);
    }

    static int bfs(int[][] box, Queue<int[]> queue, int N, int M) {
        int days = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M && box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }

            days++;
        }

        return days;
    }
}
