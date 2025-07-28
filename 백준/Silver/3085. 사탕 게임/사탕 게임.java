import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static char[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr =new char[n][n];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {

                swap(i, j, i, j + 1);
                count = Math.max(count, count());
                swap(i, j, i, j + 1);

                swap(j, i, j + 1, i);
                count = Math.max(count, count());
                swap(j, i, j + 1, i);

            }
        }

        System.out.println(count);

    }


    public static void swap(int row, int col, int row2, int col2) {
        char temp = arr[row][col];
        arr[row][col] = arr[row2][col2];
        arr[row2][col2] = temp;
    }

    public static int count() {
        int max = 1;

        for (int i = 0; i < n; i++) {
            int rowCount = 1;
            int colCount = 1;

            for (int j = 1; j < n; j++) {
                if (arr[j][i] == arr[j - 1][i]) colCount++;
                else colCount = 1;

                if (arr[i][j] == arr[i][j - 1]) rowCount++;
                else rowCount = 1;

                max = Math.max(max, Math.max(rowCount, colCount));
            }

        }

        return max;
    }

}