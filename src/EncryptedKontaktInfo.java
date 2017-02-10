public class EncryptedKontaktInfo implements KontaktInfo {
    private final StringEncryptor stringEncryptor;
    private final KontaktInfoImpl encryptedValue;

    public EncryptedKontaktInfo(StringEncryptor stringEncryptor, KontaktInfoImpl value) {
        this.stringEncryptor = stringEncryptor;
        EncryptedJaNei encryptedIsEmail = new EncryptedJaNei(stringEncryptor, value.getIsEmail());
        String encryptedName = stringEncryptor.encrypt(value.getName());
        this.encryptedValue = new KontaktInfoImpl(value.getId(), encryptedIsEmail, encryptedName);
    }

    @Override
    public JaNei getIsEmail() {
        return encryptedValue.getIsEmail();
    }

    @Override
    public String getName() {
        return encryptedValue.getName();
    }

    @Override
    public int getId() {
        return encryptedValue.getId();
    }

    public KontaktInfoImpl decrypt() {
        int decryptedId = encryptedValue.getId();
        JaNeiImpl decryptedIsEmail = ((EncryptedJaNei) encryptedValue.getIsEmail()).decrypt();
        String decryptedName = stringEncryptor.decrypt(encryptedValue.getName());
        return new KontaktInfoImpl(decryptedId, decryptedIsEmail, decryptedName);
    }
}
