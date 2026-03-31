package cns;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class w7_Blowfishalgorithm {

    // Encrypt
    public static String encrypt(String text, String key) throws Exception {

        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");

        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] enc = cipher.doFinal(text.getBytes());

        return Base64.getEncoder().encodeToString(enc);
    }

    // Decrypt
    public static String decrypt(String text, String key) throws Exception {

        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");

        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] dec = cipher.doFinal(Base64.getDecoder().decode(text));

        return new String(dec);
    }

    public static void main(String[] args) {

        try {
            String text = "Hello World";
            String key = "451017189"; // key (8+ chars)

            String encrypted = encrypt(text, key);
            System.out.println("Encrypted: " + encrypted);

            String decrypted = decrypt(encrypted, key);
            System.out.println("Decrypted: " + decrypted);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}