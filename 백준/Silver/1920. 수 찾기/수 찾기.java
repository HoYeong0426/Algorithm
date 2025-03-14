import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		int[] arr = new int[count];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < count; i++) arr[i] = Integer.parseInt(st.nextToken());

		int count2 = Integer.parseInt(br.readLine());
		int[] arr2 = new int[count2];
		int[] result = new int[count2];
		for(int i = 0; i < count2; i++) result[i] = 0;

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < count2; i++) arr2[i] = Integer.parseInt(st.nextToken());

		for(int i = 0; i < count2; i++) {
			for(int j = 0; j < count; j++) {
				if(arr2[i] == arr[j]) {
					result[i] = 1;
					break;
				} 
			}
		}
		
		for (int i : result) bw.write(String.valueOf(i) + "\n");

		br.close();
		bw.close();
        
    }
}