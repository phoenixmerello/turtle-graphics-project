package week8;

public class Password implements Encryptable {
    private String password;
    private String encryptedPassword;

    public Password(String password) {
        this.password = password;
    }

    @Override
    public void encrypt() {
        int key = 123;
        StringBuilder encrypted = new StringBuilder();
        for (char c : password.toCharArray()) {
            encrypted.append((char) (c ^ key));
        }

        encryptedPassword = encrypted.toString();
        System.out.println("Password Encrypted:");
    }

    @Override
    public String decrypt() {
        int key = 123;
        StringBuilder decrypted = new StringBuilder();
        for (char c : encryptedPassword.toCharArray()) {
            decrypted.append((char) (c ^ key));
        }

        return decrypted.toString();
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }
}
