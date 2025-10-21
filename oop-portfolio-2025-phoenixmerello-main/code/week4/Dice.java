package week4;

import java.util.Scanner;

public class Dice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("How many sides does die 1 have ");
        int die1 = scan.nextInt();
        System.out.println("How many sides does die 2 have ");
        int die2 = scan.nextInt();

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 1; i <= 3; i++){
            int randomnum1 = (int)(Math.random() * die1) +1;
            sum1 += randomnum1;
            int randomnum2 = (int)(Math.random() * die2) +1;
            sum2 += randomnum2;

            System.out.println("Roll " + i + ":");
            System.out.println("Die 1 roll = " + randomnum1);
            System.out.println("Die 2 roll = " + randomnum2);
            System.out.println();

        }

        double average1 = sum1 / 3.0;
        double average2 = sum2 / 3.0;
        System.out.println("Sum of die 1:     = " + sum1);
        System.out.println("Average of die 1: = " + average1);
        System.out.println("Sum of die 2:     = " + sum2);
        System.out.println("Average of die 2: = " + average2);





    }
}
