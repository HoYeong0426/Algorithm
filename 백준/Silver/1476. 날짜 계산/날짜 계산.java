import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int E = Integer.parseInt(arr[0]);
        int S = Integer.parseInt(arr[1]);
        int M = Integer.parseInt(arr[2]);

        int e = 1;
        int s = 1;
        int m = 1;

        int year = 1;

        while (true) {

            if (E == e && S == s && M == m) {
                System.out.println(year);
                break;
            }

            e = e % 15 + 1;
            s = s % 28 + 1;
            m = m % 19 + 1;

            year++;
        }


    }
}