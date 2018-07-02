public abstract class AsymmetricCipher {

    private String publicKey;
    private String privateKey;

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public abstract String cipher(String plaintext);
    public abstract String decipher(String cipher);
}