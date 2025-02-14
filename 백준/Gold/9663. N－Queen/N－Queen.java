import java.util.*;

public class Main {
    static int N, count;
    static int[] board;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N];
        count = 0;
        
        solve(0);
        System.out.println(count);
    }
    
    static void solve(int row) {
        if (row == N) {
            count++;
            return;
        }
        
        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row] = col;
                solve(row + 1);
            }
        }
    }
    
    static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == row - i) {
                return false;
            }
        }
        return true;
    }
}