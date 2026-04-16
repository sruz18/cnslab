import java.util.*;

public class Q3_3_Hill {

    static int[][] k = {{3, 3}, {2, 5}};

    static String encrypt(String t) {
        t = t.toUpperCase().replaceAll("[^A-Z]", "");
        if (t.length() % 2 != 0) t += "X";

        String r = "";
        for (int i = 0; i < t.length(); i += 2) {
            int a = t.charAt(i) - 'A', b = t.charAt(i + 1) - 'A';
            r += (char) (((k[0][0]*a + k[0][1]*b) % 26) + 'A');
            r += (char) (((k[1][0]*a + k[1][1]*b) % 26) + 'A');
        }
        return r;
    }

    static int inv(int a) {
        for (int i = 1; i < 26; i++) if ((a * i) % 26 == 1) return i;
        return 1;
    }

    static String decrypt(String t) {
        int d = (k[0][0]*k[1][1] - k[0][1]*k[1][0]) % 26;
        if (d < 0) d += 26;

        int id = inv(d);

        int[][] i = {
            {(k[1][1]*id)%26, (26 - k[0][1]*id%26)%26},
            {(26 - k[1][0]*id%26)%26, (k[0][0]*id)%26}
        };

        String r = "";
        for (int j = 0; j < t.length(); j += 2) {
            int a = t.charAt(j) - 'A', b = t.charAt(j + 1) - 'A';
            r += (char) (((i[0][0]*a + i[0][1]*b) % 26) + 'A');
            r += (char) (((i[1][0]*a + i[1][1]*b) % 26) + 'A');
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String t = s.nextLine();

        String e = encrypt(t);
        System.out.println("Encrypted: " + e);
        System.out.println("Decrypted: " + decrypt(e));
    }
}
