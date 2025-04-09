import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'X') {
                count++;
            } else {
                if (count % 2 != 0) {
                    System.out.println(-1);
                    return;
                }

                sb.append(replaceString(count));
                sb.append(".");
                count = 0;
            }
        }

        if (count % 2 != 0 ) {
            System.out.println(-1);
            return;
        } else {
            sb.append(replaceString(count));
        }
        
        System.out.println(sb.toString());

        
    }

    static String replaceString(int count) {
        StringBuilder sb = new StringBuilder();

        while (count >= 4) {
            sb.append("AAAA");
            count -= 4;
        }

        while (count >= 2) {
            sb.append("BB");
            count -= 2;
        }

        return sb.toString();

    }



}