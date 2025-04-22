import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int[] alpha = new int[26];

        for (char c : name.toCharArray()) {
            alpha[c - 'A']++;
        }

        int oddCount = 0;
        int oddIndex = -1;
        for (int i = 0; i < 26; i++) {
            if (alpha[i] % 2 != 0) {
                oddCount++;
                oddIndex = i;
            }
        }

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder half = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < alpha[i] / 2; j++) {
                half.append((char) (i + 'A'));
            }
        }

        StringBuilder result = new StringBuilder(half);
        if (oddIndex != -1) {
            result.append((char)(oddIndex + 'A'));
        }
        result.append(half.reverse());

        System.out.println(result.toString());
    }
}
