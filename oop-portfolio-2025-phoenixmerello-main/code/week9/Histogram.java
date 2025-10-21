package week9;

import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {

        int[] frequency = new int[10];
        Scanner scan = new Scanner(System.in);
        int number;

        System.out.println("Enter integers between 1 and 100:");
        System.out.println("(Any number outside this range will stop it)");

        while (true) {
            number = scan.nextInt();
            if (number < 1 || number > 100) {
                break;
            }

            frequency[(number -1) / 10]++;
        }

        for (int i = 0; i < frequency.length; i++) {

            int start = i * 10 + 1;
            int end = (i + 1) * 10;

            System.out.print(start + " - " + end + " | ");
            for (int j = 0; j < frequency[i]; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        scan.close();
    }
}
