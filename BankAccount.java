package ATM;

import java.io.FileNotFoundException;
import java.io.Serializable;

/**
 * Created by Zeizara on 5/15/2015.
 */
public class BankAccount implements Serializable{
    public BankAccount( double amount){
        balance = amount;
        locked=false;
    }
    public void deposit(double amount){
        if(balance<0 && (balance+amount)>0)
            locked=false;
        balance+=amount;
        System.out.println("New balance is " + balance);
    }
    public void withdraw(double amount, boolean override) throws InsufficientFundsException, FileNotFoundException {
        if(locked) {
            System.out.println("Account is locked, deposit at least " + Math.abs(balance) + " to unlock");
            return;
        }
        if(amount>balance && !override) {
            Receipt.saveReceipt();
            throw new InsufficientFundsException("Withdrawal of " + amount + " exceeds balance of " + balance);
        }
        if(!override) {
            balance -= amount;
            System.out.println("New balance is " + balance);
        }else {
            balance -= amount;
            System.out.println("New balance is " + balance);
            locked = true;
        }
    }
    public double getBalance() {
        return balance;
    }

    private boolean locked;
    private double balance;
}
