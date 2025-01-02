import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 1000000;
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int num;
        while((num = Integer.parseInt(br.readLine())) != 0) {
            boolean found = false;

            for (int i = 3; i <= num / 2; i++) {
                if (isPrime[i] && isPrime[num - i]) {
                    System.out.println(num + " = " + i + " + " + (num - i));
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("No valid prime pair found.");
            }

        }


    }

    
}