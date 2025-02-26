import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()); 
            int[][] applicants = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                applicants[i][0] = Integer.parseInt(st.nextToken());
                applicants[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(applicants, (a, b) -> Integer.compare(a[0], b[0]));

            int count = 1;
            int bestInterviewRank = applicants[0][1]; 

            for (int i = 1; i < N; i++) {
                if (applicants[i][1] < bestInterviewRank) { 
                    count++;
                    bestInterviewRank = applicants[i][1]; 
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}