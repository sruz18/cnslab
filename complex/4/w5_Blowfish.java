import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class w5_Blowfish {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter key: ");
        String key = sc.nextLine();

        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "Blowfish");
        Cipher c = Cipher.getInstance("Blowfish");

        // Encrypt
        c.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] enc = c.doFinal(text.getBytes());
        String encrypted = Base64.getEncoder().encodeToString(enc);

        // Decrypt
        c.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] dec = c.doFinal(enc);
        String decrypted = new String(dec);

        System.out.println("\nOriginal: " + text);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);

        sc.close();
    }
}