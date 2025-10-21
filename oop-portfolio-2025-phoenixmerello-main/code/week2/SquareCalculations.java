package week2;

import java.util.Scanner;

public class SquareCalculations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int side;
        int perimeter;
        int area;
        System.out.println("Enter the side");
        side = scan.nextInt();

        perimeter = (side * 4);
        System.out.println("The perimeter is: " + perimeter);

        area = (side * side);
        System.out.println("The area is: " + area);

    }
}
