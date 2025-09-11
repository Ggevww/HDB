package model;

import enums.*;

/**
 * BankAccount class represents a bank account with account number, balance, currency, and account type.
 */
public class BankAccount extends Account {
    private String accountNumber;
    private double balance;
    private Currency currency;
    private BankAccountType bankAccountType;

    /** Constructors */

    public BankAccount(String accountNumber, double balance, Currency currency, BankAccountType bankAccountType) {
        super(accountNumber, balance, currency);
        setBankAccountType(bankAccountType);
    }
    public BankAccount(String accountNumber, Currency currency, BankAccountType bankAccountType) {
        super(accountNumber, 0, currency);
        setBankAccountType(bankAccountType);
    }
    public BankAccountType getBankAccountType() {
        return bankAccountType;
    }
    public void setBankAccountType(BankAccountType bankAccountType) {
        if(bankAccountType == null){
            throw new IllegalArgumentException("Bank account type cannot be null");
        }
        this.bankAccountType = bankAccountType;
    }

    @Override
    public String toString() {
        return "BankAccount: " +
                "accountNumber='" + getAccountNumber() + '\'' +
                ", balance=" + getBalance() +
                ", currency=" + getCurrency() +
                ", bankAccountType=" + bankAccountType;
    }

}
