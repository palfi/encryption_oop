public class AwesomeStringEncryptor implements StringEncryptor{
    @Override
    public String encrypt(String value) {
        return "awesome" + value + "awesome";
    }

    @Override
    public String decrypt(String value) {
        return value.replaceAll("awesome", "");
    }
}
