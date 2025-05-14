import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int city = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());

        int maxValue = 100_000_000;
        int[][] map = new int[city + 1][city + 1];

        for (int i = 1; i <= city; i++) {
            Arrays.fill(map[i], maxValue);
            map[i][i] = 0;
        }

        for (int i = 0; i < bus; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            map[a][b] = Math.min(map[a][b], price);
        }


        for (int k = 1; k <= city; k++) {
            for(int i = 1; i <= city; i++) {
                for(int j = 1; j <= city; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }


        for (int i = 1; i <= city; i++) {
            for (int j = 1; j <= city; j++) {
                sb.append(map[i][j] == maxValue ? 0 : map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
        
    }
}