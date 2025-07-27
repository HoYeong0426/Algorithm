import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());

        int[] cost = new int[n];
        int[] city = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }


        int result = 0;
        for (int i = n - 2; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                minCost = Math.min(minCost, city[j]);
            }

            result += minCost * cost[i];
        }

        System.out.println(result);

    }

}