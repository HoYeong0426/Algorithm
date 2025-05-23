import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;

        boolean[] removed = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            if (removed[i]) continue;

            for (int j = i; j <= N; j += i) {
                if (removed[j]) continue;
                removed[j] = true;
                count++;
                if (count == K) {
                    System.out.println(j);
                    return;
                }
            }
        }

        
    }


}