import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] tallerLeft = new int[N];
        for (int i = 0; i < N; i++) {
            tallerLeft[i] = sc.nextInt();
        }

        List<Integer> line = new ArrayList<>();
        for (int i = N; i >= 1; i--) {
            line.add(tallerLeft[i - 1], i);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(line.get(i) + " ");
        }
    }
}
