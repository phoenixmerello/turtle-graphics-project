package week5;

import java.text.DecimalFormat;

public class Sphere {

        private double diameter;

        public Sphere(double diameter) {
            this.diameter = diameter;
        }

        public double getDiameter() {
            return diameter;
        }

        public void setDiameter(double diameter) {
            this.diameter = diameter;
        }

        public double getVolume() {
            double radius = diameter / 2;
            return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        }

        public double getSurfaceArea() {
            double radius = diameter / 2;
            return 4.0 * Math.PI * Math.pow(radius, 2);
        }

        public String toString() {
            double volume = getVolume();
            double surfaceArea = getSurfaceArea();

            return String.format("Sphere with diameter %.3f has a Volume of %.3f and Surface area of %.3f ", getDiameter(), getVolume(), getSurfaceArea());
        }

}

class MultiSphere {
    public static void main(String[] args) {

        DecimalFormat ftm = new DecimalFormat("0.0");

        Sphere sphere1 = new Sphere(10);
        Sphere sphere2 = new Sphere(5);
        Sphere sphere3 = new Sphere(20);


        System.out.println("Initial Sphere:");
        System.out.println("--------------");
        System.out.println(sphere1.toString());
        System.out.println(sphere2.toString());
        System.out.println(sphere3.toString());

        System.out.println();

        System.out.println("Updated Spheres:");
        System.out.println("---------------");
        sphere1.setDiameter(15);
        System.out.println("After updating, " + sphere1.toString());
        sphere2.setDiameter(21);
        System.out.println("After updating, " + sphere2.toString());
        sphere3.setDiameter(9);
        System.out.println("After updating, " + sphere3.toString());


    }

}

