package week8;

public class Driver {
    public static void main(String[] args) {

        Encryptable secretObject;

        System.out.println("------------------");
        secretObject = new Secret("HelloWorld");
        secretObject.encrypt();
        System.out.println("Decrypted Message-> " + secretObject.decrypt());

        secretObject = new Password("Password123");
        System.out.println("------------------");

        secretObject.encrypt();
        System.out.println("Encrypted Password-> " + ((Password)secretObject).getEncryptedPassword());
        System.out.println("Decrypted Password-> " + secretObject.decrypt());
        System.out.println("------------------");
    }
}
