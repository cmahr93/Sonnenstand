import java.math.BigInteger;

public class RSA extends AsymmetricCipher {

    private BigInteger e;
    private BigInteger d;
    private BigInteger n;

    public BigInteger[] calcPublicKey(BigInteger p, BigInteger q) {
        this.n = p.multiply(q);

        BigInteger publicKey[] = new BigInteger[2];

        //TODO: Prüfung, ob n 2048 bit lang ist

        BigInteger phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        this.e = phiN.nextProbablePrime();

        publicKey[0] = e;
        publicKey[1] = n;

        return publicKey;
    }

    public BigInteger[] calcPrivateKey(BigInteger p, BigInteger q) {

        BigInteger privateKey[] = new BigInteger[2];

        BigInteger phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        this.d = e.modInverse(phiN);

        privateKey[0] = this.d;
        privateKey[1] = this.n;

        return  privateKey;
    }

    @Override
    public String cipher(String plaintext) {

        //char[] plaintextChar = plaintext.toCharArray();
        char[] cipherChar = new char[plaintext.length()];
        BigInteger c;
        BigInteger p;

        for(int i = 0; i < plaintext.length(); i++) {

            p = new BigInteger(String.valueOf((int)plaintext.charAt(i)));
            c = p.modPow(this.e, this.n);

        }


        return null;
    }

    @Override
    public String decipher(String cipher) {
        return null;
    }
}