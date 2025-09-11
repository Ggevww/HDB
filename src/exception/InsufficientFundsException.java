package exception;

/**
 * Custom exception class for handling insufficient funds errors.
 */
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }

}
