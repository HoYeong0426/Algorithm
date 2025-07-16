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
		
		StringTokenizer st;
		int count = Integer.parseInt(br.readLine());
		int[][] arr = new int[count][2];
		int[] result = new int[count];

		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			result[i] = 1;
		}

		for(int i = 0; i < count; i++) {
			for(int j = 0; j < count; j++) {
				if(i == j) continue;
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) result[i] += 1;
			}
		}

		for (int i : result) bw.write(i + " ");

		br.close();
		bw.close();
        
    }
}