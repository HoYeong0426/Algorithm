import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        int last = Integer.parseInt(st.nextToken());

        for (int i = first; i <= last; i++ ) {
            if (i < 2) continue;
            boolean result = true;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    result = false;
                    break;
                }
            }
            if (result) System.out.println(i);
        }

    }

    
}