import java.util.ArrayList;
import java.util.List;

public class BruteForce {
    public static List<String> bruteForce(int n, int k) {
        List<String> result = new ArrayList<>();
        bruteForceHelper(n, k, "", result);
        return result;
    }

    private static void bruteForceHelper(int n, int k, String current, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        for (int i = 0; i < k; i++) {
            bruteForceHelper(n, k, current + i, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(bruteForce(1, 5)); // ["0","1","2","3","4"]
        System.out.println(bruteForce(2, 2)); // ["01", "10"]
        System.out.println(bruteForce(5, 3)); // []
    }
}