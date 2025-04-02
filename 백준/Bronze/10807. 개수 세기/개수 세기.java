import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        int K = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(numbers[i]) == K) count++;
        }

        System.out.println(count);
    }
}