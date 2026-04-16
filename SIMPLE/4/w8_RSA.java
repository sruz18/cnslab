package cns;

import java.math.BigInteger;
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

        // generate e starting from 3
        BigInteger e = generateE(phi);

        // private key
        BigInteger d = e.modInverse(phi);

        System.out.println("\nPublic Key (e, n): (" + e + ", " + n + ")");
        System.out.println("Private Key (d, n): (" + d + ", " + n + ")");
    }

    public static BigInteger generateE(BigInteger phi) {

        BigInteger e = BigInteger.valueOf(3);

        while (e.compareTo(phi) < 0) {
            if (phi.gcd(e).equals(BigInteger.ONE)) {
                return e;
            }
            e = e.add(BigInteger.TWO);
        }

        return null;
    }
}