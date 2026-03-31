package cns;

import java.security.MessageDigest;
import java.util.Scanner;

public class w11_MD5 {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter text: ");
            String input = sc.nextLine();

            MessageDigest md = MessageDigest.getInstance("MD5");

            // Generate hash
            String hash = getHash(md, input);

            System.out.println("\nMD5 Hash: " + hash);

            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Method to generate hash
    public static String getHash(MessageDigest md, String input) {

        md.update(input.getBytes());
        byte[] digest = md.digest();

        return bytesToHex(digest);
    }

    // Convert to hex
    public static String bytesToHex(byte[] bytes) {

        String result = "";

        for (int i = 0; i < bytes.length; i++) {
            result += String.format("%02X", bytes[i]);
        }

        return result;
    }
}