package cns;

import javax.crypto.*;
import java.util.*;

public class DESAlgorithm {
    public static void main(String[] args) {
        try {
            KeyGenerator k = KeyGenerator.getInstance("DES");
            k.init(56);
            SecretKey s = k.generateKey();

            Cipher c = Cipher.getInstance("DES");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter text to encrypt: ");
            String str = scanner.nextLine();

            c.init(Cipher.ENCRYPT_MODE, s);
            byte[] ebyte = c.doFinal(str.getBytes());
            String etext = Base64.getEncoder().encodeToString(ebyte);
            System.out.println("\nEncrypted Text: " + etext);

            c.init(Cipher.DECRYPT_MODE, s);
            byte[] dbyte = c.doFinal(Base64.getDecoder().decode(etext));
            String dtext = new String(dbyte);
            System.out.println("Decrypted Text: " + dtext);

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
