
import java.util.*;

public class Q3_3_Hill {

    static int[][] key = {{3, 3}, {2, 5}};

    static String encrypt(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "");

        if (text.length() % 2 != 0) {
            text += "X";
        }

        String result = "";

        for (int i = 0; i < text.length(); i += 2) {
            int a = text.charAt(i) - 'A';
            int b = text.charAt(i + 1) - 'A';

            int x = (key[0][0] * a + key[0][1] * b) % 26;
            int y = (key[1][0] * a + key[1][1] * b) % 26;

            result += (char) (x + 'A');
            result += (char) (y + 'A');
        }

        return result;
    }

    static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        return 1;
    }

    static String decrypt(String text) {
        int det = (key[0][0] * key[1][1] - key[0][1] * key[1][0]) % 26;
        if (det < 0) {
            det += 26;
        }

        int invDet = modInverse(det, 26);

        int[][] inv = new int[2][2];

        inv[0][0] = key[1][1] * invDet % 26;
        inv[0][1] = -key[0][1] * invDet % 26;
        inv[1][0] = -key[1][0] * invDet % 26;
        inv[1][1] = key[0][0] * invDet % 26;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (inv[i][j] < 0) {
                    inv[i][j] += 26;
                }
            }
        }

        String result = "";

        for (int i = 0; i < text.length(); i += 2) {
            int a = text.charAt(i) - 'A';
            int b = text.charAt(i + 1) - 'A';

            int x = (inv[0][0] * a + inv[0][1] * b) % 26;
            int y = (inv[1][0] * a + inv[1][1] * b) % 26;

            result += (char) (x + 'A');
            result += (char) (y + 'A');
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String encrypted = encrypt(text);
        String decrypted = decrypt(encrypted);

        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}