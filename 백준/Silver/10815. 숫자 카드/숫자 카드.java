import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        

        for (int i = 0; i < count; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        count = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < count; i ++) {
            sb.append(set.contains(Integer.parseInt(st.nextToken())) ? 1: 0).append(" ");
        }

        System.out.println(sb.toString());

    }

    
}