import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                ch += 13;
                if (ch > 90) ch -= 26;
            }

            if (Character.isLowerCase(ch)) {
                ch += 13;
                if (ch > 122) ch -= 26;
            }

            sb.append(ch);

        }

        bw.write(sb.toString());
        bw.close();
        br.close();

    }
}