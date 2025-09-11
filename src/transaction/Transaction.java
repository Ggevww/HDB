package transaction;

import exception.*;
import model.*;

/**
 * Transaction interface defines methods for deposit, withdraw, and transfer operations on bank and card accounts.
 */
public interface Transaction {
    /** Methods */
    void deposit(double amount)throws BankTransactionException;
    void withdraw(double amount)throws BankTransactionException,InsufficientFundsException;
    default void transfer(CardAccount toCard, double amount)throws BankTransactionException, InsufficientFundsException{
    }
    default void transfer(BankAccount toAccount, double amount) throws BankTransactionException, InsufficientFundsException{

    }

}
