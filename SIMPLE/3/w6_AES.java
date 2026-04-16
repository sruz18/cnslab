import javax.crypto.*;
import java.util.Base64;

public class w6_AES {
    public static void main(String[] args) throws Exception {

        String text = "Hello, Rijndael AES!";

        KeyGenerator kg = KeyGenerator.getInstance("AES");
        SecretKey key = kg.generateKey();

        Cipher c = Cipher.getInstance("AES");

        c.init(Cipher.ENCRYPT_MODE, key);
        String enc = Base64.getEncoder().encodeToString(c.doFinal(text.getBytes()));
        System.out.println("Encrypted: " + enc);

        c.init(Cipher.DECRYPT_MODE, key);
        String dec = new String(c.doFinal(Base64.getDecoder().decode(enc)));
        System.out.println("Decrypted: " + dec);
    }
}