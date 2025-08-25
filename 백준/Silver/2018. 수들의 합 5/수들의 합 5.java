import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int left = 1, right = 1, sum = 1, count = 0;

        while (left <= N) {        

            if (sum <= N) {
                if (sum == N) count++;
                right++;
                sum += right;
            } else {            
                sum -= left;
                left++;
            }
        }

        System.out.println(count);
    }
}