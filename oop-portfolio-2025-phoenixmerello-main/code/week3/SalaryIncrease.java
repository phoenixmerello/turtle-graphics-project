package week3;

import java.util.Scanner;

public class SalaryIncrease {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double salary;
        double excellent = 0.06;
        double good = 0.04;
        double poor = 0.015;
        double total;
        String performance;


        System.out.print("Enter salary: ");
        salary = scan.nextDouble();

        System.out.print("Enter performance rating(excellent, good, poor):");
        performance = scan.next();

        System.out.println("");

        if (performance.equals("excellent")) {
            excellent = salary * excellent;
            total = excellent + salary;
            System.out.println("current salary:  " + "$" + salary);
            System.out.println("raise amount:    " + "$" + excellent);
            System.out.println("Your new salary: " + "$" + total);
        }
        else if (performance.equals("good")) {
            good = salary * good;
            total = good + salary;
            System.out.println("current salary:  " + "$" + salary);
            System.out.println("raise amount:    " + "$" + good);
            System.out.println("Your new salary: " + "$" + total);
        }
        else if (performance.equals("poor")) {
            poor = salary * poor;
            total = poor + salary;
            System.out.println("current salary:  " + "$" + salary);
            System.out.println("raise amount:    " + "$" + poor);
            System.out.println("Your new salary: " + "$" + total);
        }


    }
}
