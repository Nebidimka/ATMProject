package ATM;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zeizara on 5/7/2015.
 */
public class ControlPanel {
    public static void main(String[] args) throws FileNotFoundException, WrongPinException, InsufficientFundsException {
        ParseAccounts.createCustomers();
        accountData = ParseAccounts.importCustomers(accountData);
        System.out.print("Enter customer ID\n");
        int attempts = 0;
        int id = Integer.parseInt(in.next());
        for (int i = 0; i < accountData.size() + 1; i++) {
            if (done) {
                System.out.print("Have a pleasant day!\n");
                ParseAccounts.saveCustomers(accountData);
                break;
            } else if (i == accountData.size())
                throw new FileNotFoundException("Customer is not on file\n");
            else if (accountData.get(i).getCustomerId() == id)
                enterPin(attempts, i);
        }
    }


    public static void enterPin(int attempts, int id) throws WrongPinException, InsufficientFundsException, FileNotFoundException {
        System.out.println("Enter PIN");
        int pw = Integer.parseInt(in.next());
        if (accountData.get(id).getPin() == pw)
            unlock(id);
        else if (attempts < 4) {
            attempts++;
            System.out.println("Try again\n");
            enterPin(attempts, id);
        } else
            throw new WrongPinException("Invalid PIN\n");
    }

    public static void unlock(int id) throws InsufficientFundsException, FileNotFoundException {
        System.out.println("Welcome to Aleksandr Skidelskiy's Bank, which account you want to perform operations on?\n");
        System.out.println("For Checking, type 1. For Savings, type 2\n");
        int x = Integer.parseInt(in.next());
        if (x == 1) {
            checkingControl(id);
        } else if (x == 2) {
            savingsControl(id);
        } else {
            System.out.println("Non-existant command, try again\n");
            unlock(id);
        }
    }

    public static void checkingControl(int id) throws InsufficientFundsException, FileNotFoundException {
        System.out.println("Checking account selected, to withdraw, press 1. To deposit, press 2. To view balance press 3.\n");
        int x = Integer.parseInt(in.next());
        if (x == 1) {
            System.out.println("Enter amount to withdraw\n");
            double amount = Double.parseDouble(in.next());
            accountData.get(id).thisCheckingAccount.withdraw(amount);
        } else if (x == 2) {
            System.out.println("Enter amount to deposit\n");
            double amount = Double.parseDouble(in.next());
            accountData.get(id).thisCheckingAccount.deposit(amount);
        } else if (x == 3)
            System.out.println("Balance is "+accountData.get(id).thisCheckingAccount.getBalance());
        else {
            System.out.println("Non-existant command, try again\n");
            checkingControl(id);
        }
        System.out.println("Would you like to perform another operation on this account? Y/N");
        if (in.next().equalsIgnoreCase("Y"))
            checkingControl(id);
        else {
            System.out.println("Would you like to perform operation on another account? Y/N");
            if (in.next().equalsIgnoreCase("Y"))
                savingsControl(id);
            else {
                System.out.println("Would you like a receipt? Y/N");
                done = true;
                if (in.next().equalsIgnoreCase("Y")) {
                    Receipt.saveReceipt();
                }
            }
        }
    }

    public static void savingsControl(int id) throws InsufficientFundsException, FileNotFoundException {
        System.out.println("Savings account selected, to withdraw, press 1. To deposit, press 2. To view balance press 3.\n");
        int x = Integer.parseInt(in.next());
        if (x == 1) {
            System.out.println("Enter amount to withdraw\n");
            double amount = Double.parseDouble(in.next());
            accountData.get(id).thisSavingsAccount.withdraw(amount);
        } else if (x == 2) {
            System.out.println("Enter amount to deposit\n");
            double amount = Double.parseDouble(in.next());
            accountData.get(id).thisSavingsAccount.deposit(amount);
        } else if (x == 3)
            System.out.println("Balance is "+accountData.get(id).thisSavingsAccount.getBalance());
        else {
            System.out.println("Non-existant command, try again\n");
            savingsControl(id);
        }
        System.out.println("Would you like to perform another operation on this account? Y/N");
        if (in.next().equalsIgnoreCase("Y"))
            savingsControl(id);
        else {
            System.out.println("Would you like to perform operation on another account? Y/N");
            if (in.next().equalsIgnoreCase("Y"))
                checkingControl(id);
            else {
                System.out.println("Would you like a receipt? Y/N");
                done = true;
                if (in.next().equalsIgnoreCase("Y")) {
                    Receipt.saveReceipt();
                }
            }
        }
    }

    static ArrayList<Customer> accountData = new ArrayList<Customer>();
    private static boolean done = false;
    public static Scanner in = new Scanner(System.in);
}
