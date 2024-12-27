import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        while((str = br.readLine()) != null) {
            int lower = 0, upper = 0, digits = 0, spaces = 0;
            for (char ch : str.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    upper++;
                } else if (Character.isLowerCase(ch)) {
                    lower++;
                } else if (Character.isDigit(ch)) {
                    digits++;
                } else if (ch == ' ') {
                    spaces++;
                }
            }
            bw.write(lower + " " + upper + " " + digits + " " + spaces + "\n");
        }

        bw.close();
        br.close();

    }
}