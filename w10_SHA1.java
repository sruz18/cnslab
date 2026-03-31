package cns;

import java.security.MessageDigest;

public class w10_SHA1 {

    public static void main(String[] args) {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // Test inputs
            String input1 = "";
            String input2 = "abc";
            String input3 = "abcdefghijklmnopqrstuvwxyz";

            // Generate hash
            System.out.println("SHA1(\"\") = " + getHash(md, input1));
            System.out.println("SHA1(\"abc\") = " + getHash(md, input2));
            System.out.println("SHA1(\"abcdefghijklmnopqrstuvwxyz\") = " + getHash(md, input3));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Method to generate hash
    public static String getHash(MessageDigest md, String input) {

        md.update(input.getBytes());
        byte[] output = md.digest();

        return bytesToHex(output);
    }

    // Convert bytes to hex
    public static String bytesToHex(byte[] b) {

        String result = "";

        for (int i = 0; i < b.length; i++) {
            result += String.format("%02X", b[i]);
        }

        return result;
    }
}