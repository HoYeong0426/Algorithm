import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        board = new char[row][col];

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= col - 8; j++) {
                result = Math.min(result, getCount(i, j));
            }
        }

        System.out.println(result);

    }

    static int getCount(int row, int col) {
        int count = 0;

        for (int i = row; i < row + 8; i++) {
            char prev = i % 2 == 0 ? 'W' : 'B';
            for (int j = col; j < col + 8; j++) {
                if (prev != board[i][j])
                    count++;
                prev = prev == 'W' ? 'B' : 'W';
            }
        }

        return Math.min(count, 64 - count);
    }
}
