public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            return true;
        }

        return false;
    }

    public boolean withdraw(double amount) {

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }

        return false;
    }
}

//ATM.java
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount account = new BankAccount(5000);

        int choice;

        do {

            System.out.println("\n===== ATM INTERFACE =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double deposit = sc.nextDouble();

                    if (account.deposit(deposit)) {
                        System.out.println("Amount deposited successfully.");
                        System.out.println("New Balance: ₹" + account.getBalance());
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdraw = sc.nextDouble();

                    if (account.withdraw(withdraw)) {
                        System.out.println("Please collect your cash.");
                        System.out.println("Remaining Balance: ₹" + account.getBalance());
                    } else {
                        System.out.println("Transaction failed.");
                        System.out.println("Check amount or account balance.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using ATM.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}