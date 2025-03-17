import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();
        sc.close();
        
        System.out.println(canConvert(S, T) ? 1 : 0);
    }
    
    private static boolean canConvert(String S, String T) {
        StringBuilder sb = new StringBuilder(T);
        
        while (sb.length() > S.length()) {
            if (sb.charAt(sb.length() - 1) == 'A') {
                sb.deleteCharAt(sb.length() - 1);
            } else if (sb.charAt(sb.length() - 1) == 'B') {
                sb.deleteCharAt(sb.length() - 1);
                sb.reverse();
            } else {
                return false;
            }
        }
        
        return sb.toString().equals(S);
    }
}