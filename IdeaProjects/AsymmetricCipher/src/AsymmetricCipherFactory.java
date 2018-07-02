public class AsymmetricCipherFactory {

    public static final int MIN_SECURE_KEY_LENGTH = 8;
    private int minKeyLength = MIN_SECURE_KEY_LENGTH;
    private AsymmetricCipher method;

    public void setMinKeyLength(int minKeyLength) {
        if(minKeyLength > MIN_SECURE_KEY_LENGTH)
            this.minKeyLength = minKeyLength;
    }

    public int getMinKeyLength() {
        return minKeyLength;
    }

    public void setCipher(AsymmetricCipher method) {
        this.method = method;
    }

    public AsymmetricCipher getCipher() {
        return method;
    }
}