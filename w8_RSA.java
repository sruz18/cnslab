package cns;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class w8_RSA {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter first prime number: ");
        BigInteger p = sc.nextBigInteger();

        System.out.print("Enter second prime number: ");
        BigInteger q = sc.nextBigInteger();

        // n = p * q
        BigInteger n = p.multiply(q);

        // phi = (p-1)*(q-1)
        BigInteger phi = (p.subtract(BigInteger.ONE))
                         .multiply(q.subtract(BigInteger.ONE));

        // public key
        BigInteger e = generateE(phi);

        // private key
        BigInteger d = e.modInverse(phi);

        System.out.println("\nPublic Key (e, n): (" + e + ", " + n + ")");
        System.out.println("Private Key (d, n): (" + d + ", " + n + ")");
    }

    // Generate e such that gcd(e, phi) = 1
    public static BigInteger generateE(BigInteger phi) {

        Random r = new Random();
        BigInteger e;

        do {
            e = new BigInteger(phi.bitLength(), r);
        } while (e.compareTo(BigInteger.TWO) <= 0 ||
                 e.compareTo(phi) >= 0 ||
                 !phi.gcd(e).equals(BigInteger.ONE));

        return e;
    }
}