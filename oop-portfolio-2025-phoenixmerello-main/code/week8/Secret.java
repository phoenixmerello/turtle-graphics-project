package week8;

public class Secret implements Encryptable {
    private String message;
    private String encryptedMessage;

    public Secret(String message) {
        this.message = message;
    }

    @Override
    public void encrypt() {
        StringBuilder encrypted = new StringBuilder();
        for (char c: message.toCharArray()) {
            encrypted.append((char) (c + 3));
        }

        encryptedMessage = encrypted.toString();
        System.out.println("Message encrypted using Caesar Cipher");
    }

    @Override
    public String decrypt() {
        StringBuilder decrypted = new StringBuilder();
        for (char c: encryptedMessage.toCharArray()) {
            decrypted.append((char) (c - 3));
        }

        return decrypted.toString();
    }

    public String getEncryptedMessage() {
        return encryptedMessage;
    }
}
