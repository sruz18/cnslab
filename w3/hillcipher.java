import java.util.*;

public class hillcipher {

    // Function to find modular inverse
    static int modInverse(int a) {
        a = a % 26;
        for (int x = 1; x < 26; x++)
            if ((a * x) % 26 == 1)
                return x;
        return 1;
    }

    // Function to find inverse of 3x3 matrix
    static int[][] inverse(int[][] k) {
        int det =
            k[0][0]*(k[1][1]*k[2][2] - k[1][2]*k[2][1]) -
            k[0][1]*(k[1][0]*k[2][2] - k[1][2]*k[2][0]) +
            k[0][2]*(k[1][0]*k[2][1] - k[1][1]*k[2][0]);

        det = (det % 26 + 26) % 26;
        int invDet = modInverse(det);

        int[][] inv = new int[3][3];

        inv[0][0] =  (k[1][1]*k[2][2] - k[1][2]*k[2][1]);
        inv[0][1] = -(k[0][1]*k[2][2] - k[0][2]*k[2][1]);
        inv[0][2] =  (k[0][1]*k[1][2] - k[0][2]*k[1][1]);

        inv[1][0] = -(k[1][0]*k[2][2] - k[1][2]*k[2][0]);
        inv[1][1] =  (k[0][0]*k[2][2] - k[0][2]*k[2][0]);
        inv[1][2] = -(k[0][0]*k[1][2] - k[0][2]*k[1][0]);

        inv[2][0] =  (k[1][0]*k[2][1] - k[1][1]*k[2][0]);
        inv[2][1] = -(k[0][0]*k[2][1] - k[0][1]*k[2][0]);
        inv[2][2] =  (k[0][0]*k[1][1] - k[0][1]*k[1][0]);

        // Apply mod and multiply with inverse determinant
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                inv[i][j] = inv[i][j] * invDet;
                inv[i][j] = (inv[i][j] % 26 + 26) % 26;
            }

        return inv;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input key
        int[][] key = new int[3][3];
        System.out.println("Enter 3x3 key matrix:");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                key[i][j] = sc.nextInt();

        sc.nextLine();

        // Input text
        System.out.print("Enter text: ");
        String text = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "");

        while (text.length() % 3 != 0)
            text += "X";

        String enc = "";

        // ENCRYPTION
        for (int i = 0; i < text.length(); i += 3) {
            int a = text.charAt(i) - 'A';
            int b = text.charAt(i+1) - 'A';
            int c = text.charAt(i+2) - 'A';

            int x = (key[0][0]*a + key[0][1]*b + key[0][2]*c) % 26;
            int y = (key[1][0]*a + key[1][1]*b + key[1][2]*c) % 26;
            int z = (key[2][0]*a + key[2][1]*b + key[2][2]*c) % 26;

            enc += (char)(x + 'A');
            enc += (char)(y + 'A');
            enc += (char)(z + 'A');
        }

        // DECRYPTION
        int[][] inv = inverse(key);
        String dec = "";

        for (int i = 0; i < enc.length(); i += 3) {
            int a = enc.charAt(i) - 'A';
            int b = enc.charAt(i+1) - 'A';
            int c = enc.charAt(i+2) - 'A';

            int x = (inv[0][0]*a + inv[0][1]*b + inv[0][2]*c) % 26;
            int y = (inv[1][0]*a + inv[1][1]*b + inv[1][2]*c) % 26;
            int z = (inv[2][0]*a + inv[2][1]*b + inv[2][2]*c) % 26;

            dec += (char)(x + 'A');
            dec += (char)(y + 'A');
            dec += (char)(z + 'A');
        }

        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + dec);
    }
}