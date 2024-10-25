import java.util.HashMap;
import java.util.Map;

public class FibString {
    public static boolean fibString(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        int[] counts = count.values().stream().mapToInt(Integer::intValue).sorted().toArray();
        if (counts.length < 3) return false;

        for (int i = 2; i < counts.length; i++) {
            if (counts[i] != counts[i - 1] + counts[i - 2]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(fibString("CCCABDD")); // True
        System.out.println(fibString("ABC")); // False
    }
}