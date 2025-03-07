import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] sensors = new int[N];
        for (int i = 0; i < N; i++) {
            sensors[i] = sc.nextInt();
        }

        Arrays.sort(sensors);

        if (K >= N) {
            System.out.println(0);
            return;
        }

        List<Integer> gaps = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            gaps.add(sensors[i] - sensors[i - 1]);
        }

        Collections.sort(gaps, Collections.reverseOrder());

        int totalLength = sensors[N - 1] - sensors[0];
        for (int i = 0; i < K - 1; i++) {
            totalLength -= gaps.get(i);
        }

        System.out.println(totalLength);
    }
}
