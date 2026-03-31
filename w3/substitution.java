
import java.util.*;

public class Q3_2_Subtitution {

    static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    static String encrypt(String text, String key) {
        text = text.toLowerCase();
        String result = "";

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int index = alphabet.indexOf(c);
                result += key.charAt(index);
            } else {
                result += c;
            }
        }
        return result;
    }

    static String decrypt(String text, String key) {
        String result = "";

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int index = key.indexOf(c);
                result += alphabet.charAt(index);
            } else {
                result += c;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter 26-letter key: ");
        String key = sc.nextLine();

        String encrypted = encrypt(text, key);
        String decrypted = decrypt(encrypted, key);

        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}