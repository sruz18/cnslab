package cns;

import java.util.Scanner;

public class CaesarCipher {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter any string: ");
        String str = sc.nextLine();

        System.out.print("Enter the key: ");
        int key = sc.nextInt();

        String encrypted = encrypt(str, key);
        System.out.println("\nEncrypted string: " + encrypted);

        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted string: " + decrypted);
    }

    // Encryption
    public static String encrypt(String str, int key) {

        String encrypted = "";

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            if (Character.isUpperCase(c)) {
                c = (char)(c + key % 26);
                if (c > 'Z') c -= 26;
            }
            else if (Character.isLowerCase(c)) {
                c = (char)(c + key % 26);
                if (c > 'z') c -= 26;
            }

            encrypted += c;
        }

        return encrypted;
    }
    // Decryption
   public static String decrypt(String str, int key) {
    return encrypt(str, 26 - (key % 26));
    }
}