package exceptions;

/**
 * Custom exception class for handling bank transaction-related errors.
 */
public class BankTransactionException extends Exception {
    public BankTransactionException(String message) {
        super(message);
    }
}
