package week2;

import java.util.Scanner;

public class MilesToKilometers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Miles to Kilometers Calculator");

        double Kilometers = 1.60935;
        float Miles;
        float Conversion;

        System.out.println("Enter number of miles");
        Miles = scan.nextFloat();

        Conversion = (float)(Miles * Kilometers);
        System.out.println("Conversion is " + Conversion + " Kilometers");



    }

}
