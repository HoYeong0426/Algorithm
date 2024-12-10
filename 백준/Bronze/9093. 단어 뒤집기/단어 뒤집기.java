import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
 
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            String result = "";

            for (String word : arr) {
                StringBuilder sb = new StringBuilder(word);
                result += sb.reverse().append(" ").toString();
            }
            
            System.out.println(result);
        }
		
 
	}
 
 
}