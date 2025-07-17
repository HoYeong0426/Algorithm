import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] minus = str.split("-");

        int total = sum(minus[0]);

        for (int i = 1; i < minus.length; i++) {
            total -= sum(minus[i]);
        }

        System.out.println(total);

    }

    public static int sum(String str) {
        int total = 0;

        String[] numbers = str.split("\\+");
        for (String num : numbers) {
            total += Integer.parseInt(num);
        }

        return total;
    }

}