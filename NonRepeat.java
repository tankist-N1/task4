import java.util.HashMap;
import java.util.Map;

public class NonRepeat {
    public static String nonRepeat(String s) {
        return nonRepeatHelper(s, new HashMap<>());
    }

    private static String nonRepeatHelper(String s, Map<Character, Integer> count) {
        if (s.isEmpty()) return "";

        char firstChar = s.charAt(0);
        count.put(firstChar, count.getOrDefault(firstChar, 0) + 1);

        if (count.get(firstChar) > 3) {
            return nonRepeatHelper(s.substring(1), count);
        } else {
            return firstChar + nonRepeatHelper(s.substring(1), count);
        }
    }

    public static void main(String[] args) {
        System.out.println(nonRepeat("abracadabra")); // " brcdbr"
        System.out.println(nonRepeat("abababcac")); // "bbbcc"
    }
}