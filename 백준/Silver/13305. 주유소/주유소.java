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

        long result = 0;
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (city[i] < minCost) minCost = city[i];
            result += (long) minCost * cost[i];
        }

        System.out.println(result);

    }

}