import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) a[i][j] = line.charAt(j) - '0';
        }
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) b[i][j] = line.charAt(j) - '0';
        }

        int count = 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (a[i][j] != b[i][j]) {
                    flip(a, i, j);
                    count++;
                }
            }
        }

        if (isSame(a, b, n, m)) System.out.println(count);
        else System.out.println(-1);
    }

    static void flip(int[][] a, int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                a[i][j] = 1 - a[i][j];
            }
        }
    }

    static boolean isSame(int[][] a, int[][] b, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }
}
