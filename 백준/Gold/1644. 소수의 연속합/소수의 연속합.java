import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[N + 1];
        for (int i = 2; i * i <= N; i++) {
            for (int j = i * i; j <= N; j += i) {
                prime[j] = true;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (!prime[i]) list.add(i);
        }
        

        int left = 0, right = 0, sum = 0, count = 0;
        while (true) {

            if (sum >= N) {
                if (sum == N) count++;
                sum -= list.get(left++);
            } else {
                if (right == list.size()) break;
                sum += list.get(right++);
            }
        }

        System.out.println(count);

    }

}