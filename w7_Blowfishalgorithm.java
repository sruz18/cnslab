import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

class bf {
    public static void main(String[] args) throws Exception {
        String key = "451017189";
        String s = "Hello World";

        SecretKeySpec k = new SecretKeySpec(key.getBytes(), "Blowfish");
        Cipher c = Cipher.getInstance("Blowfish");

        c.init(Cipher.ENCRYPT_MODE, k);
        byte[] enc = c.doFinal(s.getBytes());
        System.out.println("Encrypted: " + new String(enc));

        c.init(Cipher.DECRYPT_MODE, k);
        String dec = new String(c.doFinal(enc));
        System.out.println("Decrypted: " + dec);
    }
}

/*
Encrypted: ?f·àh{í·?2w??½
Decrypted: Hello World
*/