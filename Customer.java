package ATM;

import java.io.Serializable;

/**
 * Created by Zeizara on 5/7/2015.
 */
public class Customer implements Serializable {
    public Customer(int id, int pw, SavingsAccount sa, CheckingAccount ca) {
        customerId = id;
        pin = pw;
        thisCheckingAccount = ca;
        thisSavingsAccount = sa;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getPin() {
        return pin;
    }

    public CheckingAccount thisCheckingAccount;
    public SavingsAccount thisSavingsAccount;
    private int customerId;
    private int pin;
}
