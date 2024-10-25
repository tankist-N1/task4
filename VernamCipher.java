public class VernamCipher {
    public static int[] decode(String message, String key) {
        int[] result = new int[message.length()];
        for (int i = 0; i < message.length(); i++) {
            result[i] = message.charAt(i) ^ key.charAt(i % key.length());
        }
        return result;
    }

    public static String encode(int[] message, String key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length; i++) {
            result.append((char) (message[i] ^ key.charAt(i % key.length())));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[] decoded = decode("MTUCI", "MKIIT");
        System.out.println(java.util.Arrays.toString(decoded)); // [0, 31, 28, 10, 29]
        String encoded = encode(new int[]{0, 31, 28, 10, 29}, "MKIIT");
        System.out.println(encoded); // "MTUCI"
    }
}