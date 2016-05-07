package ATM;

/**
 * Created by Zeizara on 5/15/2015.
 */
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
