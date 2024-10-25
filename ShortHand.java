public class ShortHand {
    public static String shortHand(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                if (count > 1) {
                    result.append(s.charAt(i - 1)).append('*').append(count);
                } else {
                    result.append(s.charAt(i - 1));
                }
                count = 1;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(shortHand("abbccc")); // "ab*2c*3"
        System.out.println(shortHand("vvvvaajaaaaa")); // "v*4a*2ja*5"
    }
}