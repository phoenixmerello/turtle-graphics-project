package week8;
import java.util.ArrayList;
class Employee {
    public String name;

    public Employee(String name) {
        this.name = name;
    }

    public void VacationDays() {

        System.out.println(name + " has a standard vacation policy");
    }
}

class Manager extends Employee {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void VacationDays() {

        System.out.println(super.toString() + " " + name + " has 30 vacation days");
        System.out.println("---------------------------------------------------");
    }
}

class Engineer extends Employee {

    public Engineer(String name) {
        super(name);
    }

    @Override
    public void VacationDays() {

        System.out.println(super.toString() + " " + name + " has 25 vacation days");
        System.out.println("---------------------------------------------------");
    }
}

class Associate extends Employee {

    public Associate(String name) {
        super(name);
    }

    @Override
    public void VacationDays() {

        System.out.println(super.toString() + " " + name + " has 20 vacation days");
    }
}

class Staff {
    private ArrayList<Employee> staffList;

    public Staff() {
        staffList = new ArrayList<>();
        staffList.add(new Manager("Alice"));
        staffList.add(new Engineer("Mark"));
        staffList.add(new Associate("Steve"));
    }

    public void payday() {
        for (Employee e : staffList) {
            e.VacationDays();
        }
    }
}

public class FirmVacation {

    public static void main(String[] args) {
        Staff personnel = new Staff();

        personnel.payday();
    }
}










