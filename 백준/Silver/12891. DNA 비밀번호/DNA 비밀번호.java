import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int checkResult;
    static int[] checkArr;
    static int[] myArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();
        myArr = new int[4];
        checkArr = new int[4];
        checkResult = 0;
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            myArr[i] = Integer.parseInt(st.nextToken());
            if (myArr[i] == 0) checkResult++;
        }

        for (int i = 0; i < P; i++) {
            add(arr[i]);
        }
        if (checkResult == 4) result++;

        for (int i = P; i < S; i++) {
            int j = i - P;
            add(arr[i]);
            remove(arr[j]);
            if (checkResult == 4) result++;
        }

        System.out.println(result);

    }

    public static void add(char target) {

        switch (target) {
            case 'A':
                checkArr[0]++;
                if (myArr[0] == checkArr[0]) checkResult++;
                break;
            case 'C':
                checkArr[1]++;
                if (myArr[1] == checkArr[1]) checkResult++;
                break;
            case 'G':
                checkArr[2]++;
                if (myArr[2] == checkArr[2]) checkResult++;
                break;
            case 'T':
                checkArr[3]++;
                if (myArr[3] == checkArr[3]) checkResult++;
                break;
        }

    }

    public static void remove(char target) {

        switch (target) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkResult--;
                checkArr[0]--;
                break;
            case 'C':
                  if (myArr[1] == checkArr[1]) checkResult--;
                checkArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) checkResult--;
                checkArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkResult--;
                checkArr[3]--;
                break;
        }

    }
}