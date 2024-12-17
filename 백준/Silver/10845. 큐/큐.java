import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Queue<Integer> que = new LinkedList<>();
        int num = Integer.parseInt(br.readLine());
        int last = 0;
        while(num-- > 0) {
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()) {
                case "push":
                    last = Integer.parseInt(st.nextToken());
                    que.offer(last);
                    break;
                case "pop":
                    sb.append(que.isEmpty() ? -1 : que.poll()).append("\n");
                    break;
                case "size":
                    sb.append(que.size()).append("\n");
                    break;
                case "empty":
                    sb.append(que.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(que.isEmpty() ? -1 : que.peek()).append("\n");
                    break;
                case "back":
                    if (que.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(last).append("\n");
                    }
                    break;
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
