package ATM;

/**
 * Created by Zeizara on 5/15/2015.
 */
public class WrongPinException extends Exception{
    public WrongPinException(String message) {
        super(message);
    }
}
