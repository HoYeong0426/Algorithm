import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map = new int[10][10];
    static int[] paper = new int[] {0, 5, 5, 5, 5, 5};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);

    }


    static void dfs(int row, int col, int count) {

        if (result <= count) return;

        if (row == 10) {
            result = Math.min(result, count);
            return;
        }

        if (col == 10) {
            dfs(row + 1, 0, count);
            return;
        }

        if (map[row][col] == 1) {

            for (int size = 5; size > 0; size--) {
                if (paper[size] > 0 && canAttach(row, col, size)) {
                    attach(row, col, size, 0);
                    paper[size]--;
                    dfs(row, col, count + 1);
                    paper[size]++;
                    attach(row, col, size, 1);

                }
            }

        } else {
            dfs(row, col + 1, count);
        }

    }

    public static boolean canAttach(int row, int col, int size) {
        if (row + size > 10 || col + size > 10) return false;

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] == 0)  return false;
            }
        }

        return true;
    }

    public static void attach(int row, int col, int size, int value) {

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                map[i][j] = value;
            }
        }

    }


}