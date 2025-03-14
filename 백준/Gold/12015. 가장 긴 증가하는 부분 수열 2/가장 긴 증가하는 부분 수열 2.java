import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        List<Integer> lis = new ArrayList<>();
        
        for (int num : arr) {
            int idx = binarySearch(lis, num);
            if (idx < lis.size()) {
                lis.set(idx, num);
            } else {
                lis.add(num);
            }
        }
        
        System.out.println(lis.size());
    }
    
    public static int binarySearch(List<Integer> lis, int target) {
        int left = 0, right = lis.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (lis.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}