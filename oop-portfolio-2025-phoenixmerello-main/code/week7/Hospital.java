package week7;

class Employees {
    protected String name;
    protected int employeeID;

    public Employees(String name, int employeeID) {
        this.name = name;
        this.employeeID = employeeID;
    }

    public void displayInfo() {
        System.out.println(name + " (Emp# " + employeeID + ") ");
    }
}


class Doctor extends Employees {
    public Doctor(String name, int employeeID) {

        super(name, employeeID);
    }

    public void specialize() {

        System.out.println("Doctor: " + name + "ID: " + employeeID + " specializes in treating patients");
        System.out.println("-----------------------------------------------------------------");
    }
}


class Nurse extends Employees {
    public Nurse(String name, int employeeID) {

        super(name, employeeID);
    }

    public void patients() {

        System.out.println("Nurse: " + name + "ID: " + employeeID + " is taking care of patients");
        System.out.println("-----------------------------------------------------------------");
    }
}


class Receptionist extends Employees {
    public Receptionist(String name, int employeeID) {

        super(name, employeeID);
    }

    public void frontDesk() {

        System.out.println("Receptionist: " + name + "ID: " + employeeID + " is managing the front desk");
        System.out.println("-----------------------------------------------------------------");
    }
}


class Cleaner extends Employees {
    public Cleaner(String name, int employeeID) {

        super(name, employeeID);
    }

    public void sweep() {

        System.out.println("Cleaner: " + name + "ID: " + employeeID + " is sweeping the hospital");
    }
}


public class Hospital {
    public static void main(String[] args) {

        Doctor doctor = new Doctor("Dr. Richardson ", 1001);
        Nurse nurse = new Nurse("Molly ", 1002);
        Receptionist receptionist = new Receptionist("Sarah ", 1003);
        Cleaner cleaner = new Cleaner("John ", 1004);

        doctor.specialize();
        nurse.patients();
        receptionist.frontDesk();
        cleaner.sweep();
    }
}
