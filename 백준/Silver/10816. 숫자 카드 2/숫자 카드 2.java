import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		

		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < num; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int num2 = Integer.parseInt(br.readLine());
		int[] arr2 = new int[num2];
		int[] arr3 = new int[num2];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < num2; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
			arr3[i] = arr2[i];
		}

		Arrays.sort(arr2);
		Map<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < num; i++) {
			if(Arrays.binarySearch(arr2, arr[i]) >= 0) map.put(arr[i], map.getOrDefault(arr[i], 0) + 1) ;
		}

		for(int i = 0; i < num2; i++) {
			bw.write(String.valueOf(map.getOrDefault(arr3[i], 0)) + " ");
		}

		br.close();
		bw.close();
        
    }

}