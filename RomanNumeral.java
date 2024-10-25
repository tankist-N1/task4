public class RomanNumeral {
    public static String convertToRome(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(symbols[i]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToRome(8)); // "VIII"
        System.out.println(convertToRome(1234)); // "MCCXXXIV"
        System.out.println(convertToRome(52)); // "LII"
    }
}