public class KontaktInfoImpl implements KontaktInfo {
    private final int id;
    private final JaNei isEmail;
    private final String name;

    public KontaktInfoImpl(int id, JaNei isEmail, String name) {
        this.id = id;
        this.isEmail = isEmail;
        this.name = name;
    }

    @Override
    public JaNei getIsEmail() {
        return isEmail;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }

    public boolean shouldBeEncrypted() {
        return id == 1;
    }

}
