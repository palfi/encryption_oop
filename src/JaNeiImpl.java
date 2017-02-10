public class JaNeiImpl implements JaNei {
    private String value;

    public JaNeiImpl(String value) {
        if (!value.equals("J") && !value.equals("N")) {
            throw new IllegalArgumentException("J eller N");
        }
        this.value = value;
    }

    @Override
    public String toStringRep() {
        return value;
    }
}
