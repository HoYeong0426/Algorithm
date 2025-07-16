import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int[] hobbit;
    static List<Integer> list;
    static boolean found = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        hobbit = new int[9];
        for (int i = 0; i < 9; i++) {
            hobbit[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(hobbit);

        dfs(0, 0, new ArrayList<>());

        for (int i : list) {
            System.out.println(i);
        }

    }

    public static void dfs(int n, int weight, List<Integer> result) {
        if (found) return;

        if (result.size() == 7 && weight == 100) {
            list = new ArrayList<>(result);
            found = true;
            return;
        }
        
        for (int i = n; i < 9; i++) {
            result.add(hobbit[i]);
            dfs(i + 1, weight + hobbit[i], result);
            result.remove(result.size() - 1);
        }

    }

}