import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class w4_DES {

    public static void main(String[] args) {

        try {
            // Generate DES key
            KeyGenerator kg = KeyGenerator.getInstance("DES");
            kg.init(56); // 56-bit key
            SecretKey key = kg.generateKey();

            // Create Cipher
            Cipher cipher = Cipher.getInstance("DES");

            // Take input
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter text to encrypt: ");
            String text = sc.nextLine();

            // Encrypt
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(text.getBytes());
            String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
            System.out.println("\nEncrypted Text: " + encryptedText);

            // Decrypt
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            String decryptedText = new String(decryptedBytes);
            System.out.println("Decrypted Text: " + decryptedText);

            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}