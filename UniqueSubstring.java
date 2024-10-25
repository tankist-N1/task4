import java.util.HashMap;
import java.util.Map;

public class UniqueSubstring {
    public static String uniqueSubstring(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        int maxCount = 0;
        int maxIndex = -1;
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxIndex = s.indexOf(entry.getKey());
            }
        }

        return maxIndex % 2 == 0 ? "чет" : "нечет";
    }

    public static void main(String[] args) {
        System.out.println(uniqueSubstring("31312131")); // "нечет"
        System.out.println(uniqueSubstring("1111111")); // "чет"
        System.out.println(uniqueSubstring("12223234333")); // "чет"
    }
}