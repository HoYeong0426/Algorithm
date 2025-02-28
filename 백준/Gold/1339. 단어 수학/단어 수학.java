import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        sc.nextLine();
        String[] words = new String[N];
        
        for (int i = 0; i < N; i++) {
            words[i] = sc.nextLine();
        }
        
        Map<Character, Integer> weightMap = new HashMap<>();
        
        for (String word : words) {
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                int power = len - i - 1;
                weightMap.put(c, weightMap.getOrDefault(c, 0) + (int) Math.pow(10, power));
            }
        }
        
        List<Map.Entry<Character, Integer>> weightList = new ArrayList<>(weightMap.entrySet());
        weightList.sort((a, b) -> b.getValue() - a.getValue());
        
        int[] numAssign = new int[26];
        int num = 9;
        for (Map.Entry<Character, Integer> entry : weightList) {
            numAssign[entry.getKey() - 'A'] = num--;
        }
        
        int sum = 0;
        for (String word : words) {
            int value = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                value = value * 10 + numAssign[c - 'A'];
            }
            sum += value;
        }
        
        System.out.println(sum);
    }
}