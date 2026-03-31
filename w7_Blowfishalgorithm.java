import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class w7_Blowfishalgorithm {
    public static void main(String[] args) throws Exception {
        String s = "Hello World", k = "451017189";
        SecretKeySpec key = new SecretKeySpec(k.getBytes(), "Blowfish");
        Cipher c = Cipher.getInstance("Blowfish");

        c.init(Cipher.ENCRYPT_MODE, key);
        String e = Base64.getEncoder().encodeToString(c.doFinal(s.getBytes()));
        c.init(Cipher.DECRYPT_MODE, key);

        System.out.println("Encrypted: " + e);
        System.out.println("Decrypted: " + new String(c.doFinal(Base64.getDecoder().decode(e))));
    }
}