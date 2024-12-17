import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Deque<Integer> dq = new LinkedList<>();

        int num = Integer.parseInt(br.readLine());
        while(num-- > 0) {
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "push_front":
                    dq.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dq.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(dq.isEmpty() ? -1 : dq.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    sb.append(dq.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append("\n");
                    break;
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
        
    }

}