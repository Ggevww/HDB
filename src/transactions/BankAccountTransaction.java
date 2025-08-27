package transactions;

import enums.BankAccountType;
import exceptions.*;
import models.BankAccount;

/**
 * BankAccountTransaction class implements the Transaction interface to handle deposits, withdrawals, and transfers for a BankAccount.
 */
public class BankAccountTransaction implements Transaction{
    BankAccount account;

    public BankAccountTransaction(BankAccount account){
        this.account = account;
    }

    @Override
    public void deposit(double amount) throws BankTransactionException {
        if(amount <= 0){
            throw new BankTransactionException("Amount must be greater than zero");
        }
        if(account.getBankAccountType() == BankAccountType.CREDIT){
            throw new BankTransactionException("Your account is credit");
        }
        account.setBalance(account.getBalance() + amount);


    }
    @Override
    public void withdraw(double amount) throws BankTransactionException, InsufficientFundsException {
        if(amount <= 0){
            throw new BankTransactionException("Amount must be greater than zero");
        }
        if(account.getBankAccountType() == BankAccountType.DEBIT){
            throw new BankTransactionException("Your account is debit");
        }
        if(account.getBalance()<amount){
            throw new InsufficientFundsException("Insufficient balance");
        }
        account.setBalance(account.getBalance() - amount);



    }

    @Override
    public void transfer(BankAccount toAccount, double amount) throws BankTransactionException, InsufficientFundsException{
        if (amount <= 0) {
            throw new BankTransactionException("Amount must be greater than zero");
        }
        if(account.getBankAccountType() == BankAccountType.CREDIT || toAccount.getBankAccountType() == BankAccountType.DEBIT){
            throw new BankTransactionException("You should transfer money from debit account to credit");
        }
        if(account.getBalance()<amount){
            throw new InsufficientFundsException("Insufficient balance");
        }
        withdraw(amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

    }
}
