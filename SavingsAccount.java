package ATM;

import java.io.FileNotFoundException;
import java.io.Serializable;

/**
 * Created by Zeizara on 5/7/2015.
 */
public class SavingsAccount extends BankAccount implements Serializable {
    public SavingsAccount(double amount){
        super(amount);
    }
    public void deposit(double amount) {
        Receipt.addData("Savings "+getBalance()+" + "+amount+" = "+(int)(getBalance()+amount));
        super.deposit(amount);
    }
    public void withdraw(double amount) throws InsufficientFundsException, FileNotFoundException {
        Receipt.addData("Savings "+getBalance()+" - "+amount+" = "+(int)(getBalance()-amount));
        super.withdraw(amount, false);
    }
}
