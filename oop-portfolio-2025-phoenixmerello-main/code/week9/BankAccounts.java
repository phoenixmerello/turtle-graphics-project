package week9;
import java.util.Scanner;
class CustomerAccount {
    private String customerName;
    private double balance;

    public CustomerAccount(String customerName, double initialDeposit) {
        this.customerName = customerName;
        if (initialDeposit >= 0) {
            this.balance = initialDeposit;
        }

        else {
            System.out.println("Initial deposit must be non-Negative");
            this.balance = 0;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }

        else {
            System.out.println("Deposit amount must be positive (above 0)");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("withdrew: $" + amount);
        }

        else {
            System.out.println("Invalid withdrawal amount");
        }
    }

    public void addInterest() {
        double interest = balance * 0.03;
        balance += interest;
        System.out.println("Added 3% interest: $" + interest);
    }

    public void displayAccount() {
        System.out.println("Account for " + customerName + " has a balance of: $" + balance);
    }

    public double getBalance() {
        return balance;
    }
}



class Bank {
    private CustomerAccount[] accounts;
    private int accountCount;

    public Bank() {
        accounts = new CustomerAccount[30];
        accountCount = 0;
    }

    public void addAccount(String customerName, double initialDeposit) {
        if (accountCount < 30) {
            accounts[accountCount] = new CustomerAccount(customerName, initialDeposit);
            accountCount++;
            System.out.println("Account created for " + customerName + " with an initial deposit of: $" + initialDeposit);
        }

        else {
            System.out.println("Bank account limit reached (Cannot add more customers)");
        }
    }

    public CustomerAccount findAccount(String customerName) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getBalance() > 0 && accounts[i].getBalance() > 0) {
                return accounts[i];
            }
        }

        return null;
    }

    public void interestToAllAccounts() {
        for (int i = 0; i < accountCount; i++) {
            accounts[i].addInterest();
        }
    }

    public void displayAllAccounts() {
        if (accountCount == 0) {
            System.out.println("No accounts available");
        }

        else {
            for (int i = 0; i < accountCount; i++) {
                accounts[i].displayAccount();
            }
        }
    }
}



public class BankAccounts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {

            System.out.println("L&L Bank -- Please choose an options:");
            System.out.println("------------------------------------");
            System.out.println("1. Create a new account");
            System.out.println("2. Make a deposit");
            System.out.println("3. Withdraw an amount");
            System.out.println("4. Add interest to all accounts");
            System.out.println("5. Display all accounts");
            System.out.println("6. Exit");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter customer name: ");
                    String name  =  scan.nextLine();
                    System.out.println("Enter initial deposit: ");
                    double deposit = scan.nextDouble();
                    bank.addAccount(name, deposit);
                    break;

                case 2:
                    System.out.println("Enter customer name: ");
                    name  =  scan.nextLine();
                    CustomerAccount depositAccount = bank.findAccount(name);
                    if (depositAccount != null) {
                        System.out.println("Enter deposit amount: ");
                        double depositAmount = scan.nextDouble();
                        depositAccount.deposit(depositAmount);
                    }

                    else {
                        System.out.println("Account not found");
                    }
                    break;

                case 3:
                    System.out.println("Enter customer name: ");
                    name  =  scan.nextLine();
                    CustomerAccount withdrawAccount = bank.findAccount(name);
                    if (withdrawAccount != null) {
                        System.out.println("Enter withdrawal amount: ");
                        double withdrawAmount = scan.nextDouble();
                        withdrawAccount.withdraw(withdrawAmount);
                    }

                    else {
                        System.out.println("Account not found");
                    }
                    break;

                case 4:
                    bank.interestToAllAccounts();
                    break;

                case 5:
                    bank.displayAllAccounts();
                    break;

                case 6:
                    System.out.println("Exiting the Program");
                    scan.close();
                    return;

                default:
                    System.out.println("Invalid choice please try again");
            }
        }
    }
}
