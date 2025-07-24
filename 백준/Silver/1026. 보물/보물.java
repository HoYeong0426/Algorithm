import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> A = new PriorityQueue<>();
        PriorityQueue<Integer> B = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A.offer(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            B.offer(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        while (!A.isEmpty()) {
            result += A.poll() * B.poll();
        }

        System.out.println(result);

    }


}