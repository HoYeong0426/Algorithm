import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] lectures = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            lectures[i][0] = sc.nextInt();
            lectures[i][1] = sc.nextInt();
        }
        sc.close();
        
        Arrays.sort(lectures, Comparator.comparingInt(o -> o[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0][1]);
        
        for (int i = 1; i < N; i++) {
            if (pq.peek() <= lectures[i][0]) {
                pq.poll();
            }
            pq.add(lectures[i][1]);
        }
        
        System.out.println(pq.size());
    }
}