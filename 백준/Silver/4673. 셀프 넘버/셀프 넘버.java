import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {

        int max = 10_000;

        for (int i = 1; i < max; i++) {

            int count = 0;
            for (int j = i - 36; j < i; j++) {

                int now = j;
                int temp = j;

                while (temp > 0) {
                    now += temp % 10;
                    temp /= 10;
                }

                if (i == now) {
                    count++;
                    break;
                }
            }
            if (count == 0) System.out.println(i);

        }

    }

}