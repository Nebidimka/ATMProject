package ATM;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by Zeizara on 5/7/2015.
 */
public class CheckingAccount extends BankAccount implements Serializable {
    public CheckingAccount(double amount){
        super(amount);
    }
    public void deposit(double amount) {
        Receipt.addData("Checking "+getBalance()+" + "+amount+" = "+(int)(getBalance()+amount));
        super.deposit(amount);
    }
    public void withdraw(double amount) throws InsufficientFundsException, FileNotFoundException {
        Receipt.addData("Checking " + getBalance() + " - " + amount + " = " + (int) (getBalance() - amount));
        if(getBalance()<balanceThreshold) {
            System.out.println("Following operation will put this account below $" + balanceThreshold + ", resulting in a $" + fee + "fee. Continue? Y/N");
            Scanner in = new Scanner(System.in);
            String result = in.next();
            if (result.equalsIgnoreCase("Y")) {
                super.withdraw(amount+fee,false);
                Receipt.addData("Checking fee issued " + getBalance() + " - " + fee + " = " + (int) (getBalance() - fee));
            }
        }
    }

    private double fee=35;
    private double balanceThreshold=1000;
}
