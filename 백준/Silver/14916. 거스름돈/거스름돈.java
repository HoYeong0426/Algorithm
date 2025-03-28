import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int count = 0;
        while (n > 0) {
            if (n % 5 == 0) {
                count += n / 5;
                break;
            }
            n -= 2;
            count++;
        }

        System.out.println(n < 0 ? -1 : count);
    }
}