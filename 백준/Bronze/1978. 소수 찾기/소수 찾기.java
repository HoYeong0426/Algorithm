import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()) {
            boolean result = true;

            int num = Integer.parseInt(st.nextToken());

            if (num == 1) continue;

            for (int i = 2; i <= Math.sqrt(num); i++ ){
                if (num % i == 0) {
                    result = false;
                    break;
                }
            }

            if (result) count++;
        }

        System.out.println(count);

    }

    
}