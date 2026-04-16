import java.util.*;

public class Q3_3_Hill {

    static int[][] k = {{3, 3}, {2, 5}};

    static String encrypt(String t) {
        t = t.toUpperCase().replaceAll("[^A-Z]", "");
        if (t.length() % 2 != 0) t += "X";

        String r = "";
        for (int i = 0; i < t.length(); i += 2) {
            int a = t.charAt(i) - 'A';
            int b = t.charAt(i + 1) - 'A';

            r += (char)(((k[0][0]*a + k[0][1]*b) % 26) + 'A');
            r += (char)(((k[1][0]*a + k[1][1]*b) % 26) + 'A');
        }
        return r;
    }

    static int inv(int a) {
        for (int i = 1; i < 26; i++)
            if ((a * i) % 26 == 1)
                return i;
        return 1;
    }

    static String decrypt(String t) {
        int det = (k[0][0]*k[1][1] - k[0][1]*k[1][0]) % 26;
        if (det < 0) det += 26;

        int invDet = inv(det);

        int[][] inv = new int[2][2];

        inv[0][0] = (k[1][1] * invDet) % 26;
        inv[0][1] = (-k[0][1] * invDet) % 26;
        inv[1][0] = (-k[1][0] * invDet) % 26;
        inv[1][1] = (k[0][0] * invDet) % 26;

        // Fix negative values
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                if (inv[i][j] < 0)
                    inv[i][j] += 26;

        String r = "";
        for (int i = 0; i < t.length(); i += 2) {
            int a = t.charAt(i) - 'A';
            int b = t.charAt(i + 1) - 'A';

            r += (char)(((inv[0][0]*a + inv[0][1]*b) % 26) + 'A');
            r += (char)(((inv[1][0]*a + inv[1][1]*b) % 26) + 'A');
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter text: ");
        String t = s.nextLine();

        String e = encrypt(t);
        System.out.println("Encrypted: " + e);
        System.out.println("Decrypted: " + decrypt(e));
    }
}
