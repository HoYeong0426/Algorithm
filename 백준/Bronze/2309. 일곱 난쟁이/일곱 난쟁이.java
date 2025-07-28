import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] hobbit = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            hobbit[i] = Integer.parseInt(br.readLine());
            sum += hobbit[i];
        }

        Arrays.sort(hobbit);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j) continue;
                if (sum - hobbit[i] - hobbit[j] == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k == i || k == j) continue;
                        System.out.println(hobbit[k]);
                    }
                    return;
                }
            }
        }

    }
}