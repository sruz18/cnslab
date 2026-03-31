import java.util.*;

public class hillcipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine().toLowerCase();

        int[][] key = new int[2][2];

        // Input key matrix
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                key[i][j] = sc.nextInt();

        // Make even length
        if (text.length() % 2 != 0)
            text += "x";

        String enc = "", dec = "";

        // 🔹 Encryption
        for (int i = 0; i < text.length(); i += 2) {
            int a = text.charAt(i) - 'a';
            int b = text.charAt(i + 1) - 'a';

            int c1 = (key[0][0]*a + key[0][1]*b) % 26;
            int c2 = (key[1][0]*a + key[1][1]*b) % 26;

            enc += (char)(c1 + 'a');
            enc += (char)(c2 + 'a');
        }

        // 🔹 Determinant
        int det = key[0][0]*key[1][1] - key[0][1]*key[1][0];
        det = (det % 26 + 26) % 26;

        // 🔹 Inverse of determinant
        int invDet = 1;
        for (int i = 1; i < 26; i++)
            if ((det * i) % 26 == 1) invDet = i;

        // 🔹 Inverse matrix
        int[][] inv = new int[2][2];
        inv[0][0] = key[1][1];
        inv[1][1] = key[0][0];
        inv[0][1] = -key[0][1];
        inv[1][0] = -key[1][0];

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                inv[i][j] = (inv[i][j] * invDet % 26 + 26) % 26;

        // 🔹 Decryption
        for (int i = 0; i < enc.length(); i += 2) {
            int a = enc.charAt(i) - 'a';
            int b = enc.charAt(i + 1) - 'a';

            int p1 = (inv[0][0]*a + inv[0][1]*b) % 26;
            int p2 = (inv[1][0]*a + inv[1][1]*b) % 26;

            dec += (char)(p1 + 'a');
            dec += (char)(p2 + 'a');
        }

        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + dec);
    }
}