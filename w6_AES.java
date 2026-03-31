import java.util.Base64;
import javax.crypto.*;
import java.util.Scanner;

public class w6_AES {

    // Generate AES Key
    public static SecretKey generateKey() throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(128); // AES-128
        return kg.generateKey();
    }

    // Encrypt
    public static String encrypt(String text, SecretKey key) throws Exception {
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] enc = c.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(enc);
    }

    // Decrypt
    public static String decrypt(String encryptedText, SecretKey key) throws Exception {
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] dec = c.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(dec);
    }

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter text: ");
            String text = sc.nextLine();

            // Generate key (like first code)
            SecretKey key = generateKey();

            // Encrypt
            String encrypted = encrypt(text, key);
            System.out.println("\nEncrypted Text: " + encrypted);

            // Decrypt
            String decrypted = decrypt(encrypted, key);
            System.out.println("Decrypted Text: " + decrypted);

            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}