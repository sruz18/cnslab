import java.util.*;

public class substitution {
    
    static String a = "abcdefghijklmnopqrstuvwxyz ";
    static String b = "zyxwvutsrqponmlkjihgfedcba ";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter any string: ");
        String text = sc.nextLine().toLowerCase();

        String enc = encrypt(text);
        String dec = decrypt(enc);

        System.out.println("Encrypted text: " + enc);
        System.out.println("Decrypted text: " + dec);
    }

    static String encrypt(String text) {
        String res = "";
        for (char ch : text.toCharArray()) {
            int i = a.indexOf(ch);
            res += (i != -1) ? b.charAt(i) : ch;
        }
        return res;
    }

    static String decrypt(String text) {
        String res = "";
        for (char ch : text.toCharArray()) {
            int i = b.indexOf(ch);
            res += (i != -1) ? a.charAt(i) : ch;
        }
        return res;
    }
}