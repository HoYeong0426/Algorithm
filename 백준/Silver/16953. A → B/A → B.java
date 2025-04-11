import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{B, 1});

        while (!queue.isEmpty()) {
            long[] current = queue.poll();
            long num = current[0];
            long count = current[1];

            if (num == A) {
                System.out.println(count);
                return;
            }

            if (num % 2 == 0 && num / 2 >= A) {
                queue.add(new long[]{num / 2, count + 1});
            }

            if (num % 10 == 1 && num / 10 >= A) {
                queue.add(new long[]{num / 10, count + 1});
            }
        }

        System.out.println(-1);
    }
}