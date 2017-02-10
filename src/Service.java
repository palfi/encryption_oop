public class Service {
    private final Repo repo;

    public Service(Repo repo) {
        this.repo = repo;
    }

    public void insert(KontaktInfoImpl kontaktInfo) {
        if (kontaktInfo.shouldBeEncrypted()) {
            repo.insert(new EncryptedKontaktInfo(new AwesomeStringEncryptor(), kontaktInfo));
        } else {
            repo.insert(kontaktInfo);
        }
    }

    public KontaktInfo get(int id, String bruker) {
        KontaktInfo kontaktInfo = repo.get(id);
        if (kontaktInfo instanceof EncryptedKontaktInfo && isAllowedToDecrypt(bruker)) {
            return ((EncryptedKontaktInfo)kontaktInfo).decrypt();
        }
        return kontaktInfo;
    }

    private boolean isAllowedToDecrypt(String bruker) {
        return bruker.equals("bruker");
    }
}
