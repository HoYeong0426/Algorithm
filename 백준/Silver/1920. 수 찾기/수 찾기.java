import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int num;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        arr = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        int num2 = Integer.parseInt(br.readLine());
        int[] arr2 = new int[num2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < num2; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < num2; i++) {
            System.out.println(isContains(arr2[i]));
        }


    }

    public static int isContains(int n) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2; 

            if (arr[mid] == n) {
                return 1;
            } else if (arr[mid] >= n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return 0;
    }

}