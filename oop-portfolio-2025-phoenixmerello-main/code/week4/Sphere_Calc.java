package week4;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Sphere_Calc {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the radius of the sphere");
        double radius = scan.nextDouble();

        double volume = (4.0 /3.0) * Math.PI * Math.pow(radius, 3);
        double SurfaceArea = (4.0 / 2.0) * Math.PI * Math.pow(radius, 2);

        DecimalFormat ftm = new DecimalFormat("0.0000");

        System.out.println();
        System.out.println("The volume of the sphere is: " + ftm.format(volume));
        System.out.println("The Surface area of the sphere is: " + ftm.format(SurfaceArea));

    }
}
