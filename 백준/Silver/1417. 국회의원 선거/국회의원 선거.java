import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int dasom = sc.nextInt();
        int bribe = 0;

        if (N == 1) {
            System.out.println(0);
            return;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i < N; i++) {
            pq.add(sc.nextInt());
        }

        while (!pq.isEmpty() && pq.peek() >= dasom) {
            int top = pq.poll();
            pq.add(top - 1);
            dasom++;
            bribe++;
        }

        System.out.println(bribe);
    }
}
