import java.security.MessageDigest;

public class w10_SHA {

    public static String hash(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] messageDigest = md.digest(input.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public static void main(String[] args) throws Exception {
        String message = "Banking Transaction Data";

        String hashedMessage = hash(message);

        System.out.println("Original: " + message);
        System.out.println("SHA-1   : " + hashedMessage);
    }
}