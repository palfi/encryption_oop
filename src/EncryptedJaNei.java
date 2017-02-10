public class EncryptedJaNei implements JaNei {
    private final String encryptedValue;
    private final StringEncryptor stringEncryptor;

    public EncryptedJaNei(StringEncryptor stringEncryptor, JaNei value) {
        this.stringEncryptor = stringEncryptor;
        this.encryptedValue = stringEncryptor.encrypt(value.toStringRep());
    }

    @Override
    public String toStringRep() {
        return encryptedValue;
    }

    public JaNeiImpl decrypt() {
        return new JaNeiImpl(stringEncryptor.decrypt(encryptedValue));
    }
}
