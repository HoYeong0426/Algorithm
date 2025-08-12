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

		StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] lanCables = new long[K];

        long maxLen = 0;
        for (int i = 0; i < K; i++) {
            lanCables[i] = Long.parseLong(br.readLine());
            maxLen = Math.max(maxLen, lanCables[i]);
        }

        long left = 1;
        long right = maxLen;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int i = 0; i < K; i++) {
                count += lanCables[i] / mid;
            }

            if (count >= N) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

		bw.write(String.valueOf(answer));

		br.close();
		bw.close();
        
    }

}