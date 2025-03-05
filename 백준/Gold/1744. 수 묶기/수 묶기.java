import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        int ones = 0, zeroCount = 0, sum = 0;

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num > 1) positive.add(num);
            else if (num == 1) ones++;
            else if (num == 0) zeroCount++;
            else negative.add(num);
        }

        positive.sort(Collections.reverseOrder());
        negative.sort(Comparator.naturalOrder());

        for (int i = 0; i < positive.size() - 1; i += 2)
            sum += positive.get(i) * positive.get(i + 1);
        if (positive.size() % 2 == 1)
            sum += positive.get(positive.size() - 1);

        for (int i = 0; i < negative.size() - 1; i += 2)
            sum += negative.get(i) * negative.get(i + 1);
        if (negative.size() % 2 == 1 && zeroCount == 0)
            sum += negative.get(negative.size() - 1);

        sum += ones;
        System.out.println(sum);
    }
}