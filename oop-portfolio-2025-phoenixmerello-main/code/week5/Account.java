package week5;

import java.text.NumberFormat;
import java.util.Scanner;

public class Account
{
    private final double RATE = 0.035;  // interest rate of 3.5%

    private String name;
    private long acctNumber;
    private double balance;

    //-----------------------------------------------------------------
    //  Sets up this account with the specified owner, account number,
    //  and initial balance.
    //-----------------------------------------------------------------
    public Account (String owner, long account, double initial)
    {
        name = owner;
        acctNumber = account;
        balance = initial;
    }

    //-----------------------------------------------------------------
    //  Deposits the specified amount into this account and returns
    //  the new balance. The balance is not modified if the deposit
    //  amount is invalid.
    //-----------------------------------------------------------------
    public double deposit (double amount)
    {
        if (amount > 0)
            balance = balance + amount;

        return balance;
    }

    //-----------------------------------------------------------------
    //  Withdraws the specified amount and fee from this account and
    //  returns the new balance. The balance is not modified if the
    //  withdraw amount is invalid or the balance is insufficient.
    //-----------------------------------------------------------------
    public double withdraw (double amount, double fee)
    {
        if (amount+fee > 0 && amount+fee < balance)
            balance = balance - amount;

        return balance;
    }

    //-----------------------------------------------------------------
    //  Adds interest to this account and returns the new balance.
    //-----------------------------------------------------------------
    public double addInterest ()
    {
        balance += (balance * RATE);
        return balance;
    }

    //-----------------------------------------------------------------
    //  Returns the current balance of this account.
    //-----------------------------------------------------------------
    public double getBalance ()
    {
        return balance;
    }

    //-----------------------------------------------------------------
    //  Returns a one-line description of this account as a string.
    //-----------------------------------------------------------------
    public String toString ()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        return (acctNumber + "\t" + name + "\t" + fmt.format(balance));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Enter your account number: ");
        long acctNumber = sc.nextLong();

        System.out.println("Enter your balance: ");
        Double balance = sc.nextDouble();

        Account myAccount = new Account(name, acctNumber, balance);

        System.out.println("                 Name   " + "AcctNum " + "Balance");
        System.out.println("Account created: " + myAccount);

        System.out.println("Enter deposit amount:");
        double depositAmount = sc.nextDouble();
        myAccount.deposit(depositAmount);
        System.out.println("After deposit: " + myAccount);

        System.out.println("Enter withdraw amount:");
        double withdrawAmount = sc.nextDouble();
        myAccount.withdraw(withdrawAmount, depositAmount);
        System.out.println("After withdrawal: " + myAccount);

        myAccount.addInterest();
        System.out.println("After adding interest: " + myAccount);







    }
}