import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] board;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N];

        dfs(0);

        System.out.println(count);

    }

    static void dfs(int depth) {

        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {

            if (isCorrect(depth, i)) {
                board[depth] = i;
                dfs(depth + 1);
            }
            
        }

    }

    static boolean isCorrect(int row, int col) {

        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(col - board[i]) == row - i) return false;
        }

        return true;
    }
}