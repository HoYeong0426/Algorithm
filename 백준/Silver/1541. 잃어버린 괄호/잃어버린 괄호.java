import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] arr = br.readLine().split("-");
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            String[] plus = arr[i].split("\\+");

            int sum = 0;
            for (int j = 0; j < plus.length; j++) {
                sum += Integer.parseInt(plus[j]);
            }

            result = i == 0 ? result + sum : result - sum;
        }

        System.out.println(result);

    }


}