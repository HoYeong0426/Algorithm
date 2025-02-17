import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        while (num > 0) {

            if (!isPrime(num)) {
                num++;
                continue;
            }
            if (!isPalinde(num)) {
                num++;
                continue;
            }
            break;
        }

        System.out.println(num);

    }

    static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;

    }

    static boolean isPalinde(int num) {
        String str = num + "";
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) return false;
        }

        return true;

    }

}