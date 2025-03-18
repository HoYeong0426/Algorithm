import java.util.*;

public class Main {
    static int N, M, maxSafeArea = 0;
    static int[][] lab;
    static List<int[]> virusList = new ArrayList<>();
    static List<int[]> emptyList = new ArrayList<>();
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        lab = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                lab[i][j] = sc.nextInt();
                if (lab[i][j] == 2) virusList.add(new int[]{i, j});
                else if (lab[i][j] == 0) emptyList.add(new int[]{i, j});
            }
        }

        buildWalls(0, 0);
        System.out.println(maxSafeArea);
    }

    static void buildWalls(int count, int start) {
        if (count == 3) {
            maxSafeArea = Math.max(maxSafeArea, getSafeArea());
            return;
        }

        for (int i = start; i < emptyList.size(); i++) {
            int[] pos = emptyList.get(i);
            lab[pos[0]][pos[1]] = 1;
            buildWalls(count + 1, i + 1);
            lab[pos[0]][pos[1]] = 0;
        }
    }

    static int getSafeArea() {
        int[][] tempLab = new int[N][M];
        for (int i = 0; i < N; i++) tempLab[i] = lab[i].clone();

        Queue<int[]> queue = new LinkedList<>(virusList);
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = pos[0] + dx[d], ny = pos[1] + dy[d];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && tempLab[nx][ny] == 0) {
                    tempLab[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        int safeArea = 0;
        for (int[] row : tempLab) 
            for (int cell : row) 
                if (cell == 0) safeArea++;
        
        return safeArea;
    }
}