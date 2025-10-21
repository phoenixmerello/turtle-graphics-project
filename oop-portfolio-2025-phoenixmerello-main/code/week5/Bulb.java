package week5;

import java.util.Scanner;

public class Bulb {
    private boolean isOn;

    public void turnOn() {
        this.isOn = true;
    }

    public boolean isOn() {
        return this.isOn;
    }

    public String toString() {
        return this.isOn ? "On" : "Off";
    }
}

class Lights {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Bulb bulb = new Bulb();

        System.out.println("Do you want to turn the light bulb ON?: (yes/no)");
        String user = scan.nextLine();

        if (user.equals("yes")) {
            bulb.turnOn();
            System.out.println("The bulb is on: " + bulb);

        }
        else if (user.equals("no")) {
            System.out.println("The bulb is off: " + bulb);
        }

    }

}
