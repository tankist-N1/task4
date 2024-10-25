import java.util.ArrayList;
import java.util.List;

public class NumericOrder {
    public static String numericOrder(String s) {
        String[] words = s.split(" ");
        List<String> orderedWords = new ArrayList<>();

        for (int i = 1; i <= words.length; i++) {
            for (String word : words) {
                if (word.contains(String.valueOf(i))) {
                    orderedWords.add(word.replaceAll("\\d", ""));
                    break;
                }
            }
        }

        return String.join(" ", orderedWords);
    }

    public static void main(String[] args) {
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng")); // "One ring to rule them all"
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat")); // "With great power comes great responsibility"
    }
}