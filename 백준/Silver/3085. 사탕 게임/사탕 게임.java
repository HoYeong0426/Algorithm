import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int max = 1;
    static char[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                
                if (col < n - 1) {
                    swap(row, col, row, col + 1);
                    count();
                    swap(row, col, row, col + 1);
                }


                if (row < n - 1) {
                    swap(row, col, row + 1, col);
                    count();
                    swap(row, col, row + 1, col);
                }

            }
        }

        System.out.println(max);
    }

    public static void swap(int row, int col, int row2, int col2) {
        char temp = arr[row][col];
        arr[row][col] = arr[row2][col2];
        arr[row2][col2] = temp;
    }

    public static void count() {

        for (int col = 0; col < n; col++) {
            int count = 1;
            for (int row = 1; row < n; row++) {
                if (arr[row][col] == arr[row - 1][col]) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }

        for (int row = 0; row < n; row++) {
            int count = 1;
            for (int col = 1; col < n; col++) {
                if (arr[row][col] == arr[row][col - 1]) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }

    }

}