import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int minPackage = Integer.MAX_VALUE;
        int minSingle = Integer.MAX_VALUE;
        
        for (int i = 0; i < M; i++) {
            int pack = sc.nextInt();
            int single = sc.nextInt();
            
            minPackage = Math.min(minPackage, pack);
            minSingle = Math.min(minSingle, single);
        }

        int case1 = N * minSingle;
        int case2 = ((N + 5) / 6) * minPackage;
        int case3 = (N / 6) * minPackage + (N % 6) * minSingle;

        int result = Math.min(case1, Math.min(case2, case3));

        System.out.println(result);
    }
}
