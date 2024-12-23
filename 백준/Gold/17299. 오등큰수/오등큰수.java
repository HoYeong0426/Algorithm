import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        int[] result = new int[num];
        Arrays.fill(result, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num; i++) {
            
            while (!stack.isEmpty() && map.getOrDefault(arr[stack.peek()], 0) < map.getOrDefault(arr[i], 0)) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        for (int i = 0; i < num; i++) {
            sb.append(result[i]).append(" ");
        }


        bw.write(sb.toString());
        bw.close();
        br.close();

    }
}