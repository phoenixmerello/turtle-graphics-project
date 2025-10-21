package week4;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Deli_Item_Cost {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double pricePerPound;    // price per pound
        double weightOunces;  // weight in ounces
        double weight;              // weight in pounds
        double totalPrice;         // total price for the item


        NumberFormat money = NumberFormat.getCurrencyInstance(Locale.UK);
        DecimalFormat fmt = new DecimalFormat("0.00");


        System.out.println("Welcome to the CS Deli!!");
        System.out.println("------------------------");
        System.out.println("Enter the price per pound of your item: ");
        pricePerPound = scan.nextDouble();

        System.out.println("Enter the weight of (OUNCES): ");
        weightOunces = scan.nextDouble();

        weight = weightOunces / 16;
        totalPrice = pricePerPound * weight;

        System.out.println();
        System.out.println("*****" + "CS Deli" + "*****");
        System.out.println("Unit Price: " + money.format(pricePerPound));
        System.out.println("Weight: " + fmt.format(weight) + " Pounds");
        System.out.println("--------------------");
        System.out.println("TOTAL: " + money.format(totalPrice));






    }
}
