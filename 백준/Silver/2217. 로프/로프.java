import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        
        int result = 0;

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(a);

        result = n * a[0];
        for(int i = n; i > 0; i--){
            if(result < i * a[n-i]) {
                result = i * a[n-i];
            }
        }

        bw.write(String.valueOf(result));
        br.close();
        bw.close();


    }




}
