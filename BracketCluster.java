import java.util.ArrayList;
import java.util.List;

public class BracketCluster {
    public static List<String> split(String s) {
        List<String> result = new ArrayList<>();
        int balance = 0;
        StringBuilder currentCluster = new StringBuilder();

        for (char c : s.toCharArray()) {
            currentCluster.append(c);
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }
            if (balance == 0) {
                result.add(currentCluster.toString());
                currentCluster.setLength(0);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(split("()()()")); // ["()", "()", "()"]
        System.out.println(split("((()))")); // ["((()))"]
        System.out.println(split("((()))(())()()(()())")); // ["((()))", "(())", "()", "()", "(()())"]
        System.out.println(split("((())())(()(()()))")); // ["((())())", "(()(()()))"]
    }
}