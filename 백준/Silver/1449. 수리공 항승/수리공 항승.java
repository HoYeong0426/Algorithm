import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] leak = new int[N];
        for (int i = 0; i < N; i++) {
            leak[i] = sc.nextInt();
        }

        Arrays.sort(leak);
        int count = 0;
        double end = 0;

        for (int i = 0; i < N; i++) {
            if (leak[i] > end) {
                count++;
                end = leak[i] - 0.5 + L;
            }
        }

        System.out.println(count);
    }
}