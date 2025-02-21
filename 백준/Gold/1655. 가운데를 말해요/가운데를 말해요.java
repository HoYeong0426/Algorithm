import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        
        for (int i = 0; i < num; i++) {

            int N = Integer.parseInt(br.readLine());

            if (left.isEmpty() || N <= left.peek()) {
                left.add(N);
            } else {
                right.add(N);
            }


            if (left.size() > right.size() + 1) {
                right.add(left.poll());
            }

            if (right.size() > left.size()) {
                left.add(right.poll());
            }

            bw.write(left.peek() + "\n");

        }


        br.close();
        bw.close();


    }


}