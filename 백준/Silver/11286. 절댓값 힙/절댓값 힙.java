import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) {
                    return o1.compareTo(o2);
                }
                return Math.abs(o1) - Math.abs(o2);
            }
        });
        
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x != 0) {
                pq.offer(x);
            } else {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            }
        }
        
        sc.close();
    }
}
