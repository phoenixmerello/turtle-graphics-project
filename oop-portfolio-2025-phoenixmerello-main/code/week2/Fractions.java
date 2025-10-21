package week2;

import java.util.Scanner;

public class Fractions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numerator;
        int denominator;
        double fraction;

        System.out.print("Enter numerator: ");
        numerator = scan.nextInt();

        System.out.print("Enter denominator: ");
        denominator = scan.nextInt();

        fraction = (double) numerator / denominator;
        System.out.println("The fraction in decimal is: " + fraction);
    }
}
