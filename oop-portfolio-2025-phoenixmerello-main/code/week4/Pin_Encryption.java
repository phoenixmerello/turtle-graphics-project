package week4;

import java.util.Scanner;

public class Pin_Encryption {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int random_num1;
        int random_num2;

        int upper = 65536;
        int lower = 1000;

        String random_hex1;
        String random_hex2;

        String hex;
        String encryption;

        System.out.println("Enter a 4 digit pin number to encrypt: ");
        int pin = scan.nextInt();
        hex = Integer.toHexString(pin);


        random_num1 = (int)(Math.random() * (upper - lower)) + lower;
        random_num2 = (int)(Math.random() * (upper - lower)) + lower;

        random_hex1 = (Integer.toHexString(random_num1));
        random_hex2 = (Integer.toHexString(random_num2));


        encryption = hex + random_hex1 + random_hex2;
        System.out.println();
        System.out.println("Your encrypted Pin number is: " + encryption);







    }
}
