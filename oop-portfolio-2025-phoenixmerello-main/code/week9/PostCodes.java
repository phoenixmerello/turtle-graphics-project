package week9;

import java.util.Scanner;

class Person {
    private String firstName;
    private String lastName;
    private String postalCode;

    public Person(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.postalCode = postalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getPostalCode() {
        return postalCode;
    }

    public void personInfo() {
        System.out.println(firstName + " " + lastName + " " + postalCode);
    }
}

class Main {
    public static void main(String[] args) {

        Person[] people = new Person[25];
        Scanner scan = new Scanner(System.in);
        int count = 0;

        System.out.println("You can enter up to 25 people (First & Last Name and Postal codes");
        System.out.println("Enter stop as first name to stop input");
        System.out.println("-----------------------------------------");

        while (count < 25) {

            System.out.println("Enter First Name, Last Name, Postal Code (tab separated): ");
            String input = scan.nextLine().trim();

            if (input.equalsIgnoreCase("stop")) {
                break;
            }

            String[] parts = input.split("\t");

            if (parts.length != 3) {
                System.out.println("Invalid input, enter 3 values separated by tabs");
                continue;
            }

            String firstName = parts[0];
            String lastName = parts[1];
            String postalCode = parts[2];

            people[count] = new Person(firstName, lastName, postalCode);
            count++;
        }

        System.out.println("\nList of People:");
        for (int i = 0; i < count; i++) {
            people[i].personInfo();
        }

        scan.close();

    }
}



