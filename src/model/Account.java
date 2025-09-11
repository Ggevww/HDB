package model;

import enums.Currency;
/**
 * Class representing a bank account with an account number, balance, and currency.
 */
public class Account {
    private String accountNumber;
    private double balance;
    private Currency currency;
    /**
     * Constructs an Account with the specified account number, balance, and currency.
     *
     * @param accountNumber the account number
     * @param balance       the initial balance
     * @param currency      the currency of the account
     * @throws IllegalArgumentException if accountNumber is null or empty, balance is negative, or currency is null
     */
    public Account(String accountNumber, double balance, Currency currency) {
        setAccountNumber(accountNumber);
        setBalance(balance);
        setCurrency(currency);
    }
    /**
     * Constructs an Account with the specified account number and currency, initializing balance to 0.
     *
     * @param accountNumber the account number
     * @param currency      the currency of the account
     * @throws IllegalArgumentException if accountNumber is null or empty, or currency is null
     */
    public Account(String accountNumber, Currency currency) {
        setAccountNumber(accountNumber);
        setBalance(0);
        setCurrency(currency);
    }
    /** Getters and Setters */
    public String getAccountNumber(){
        return accountNumber;
    }
    void setAccountNumber(String accountNumber){
        if(accountNumber == null || accountNumber.isEmpty()){
            throw new IllegalArgumentException("Account number cannot be null or empty");
        }
        for(int i = 0; i < accountNumber.length(); i++){
            if(!Character.isDigit(accountNumber.charAt(i))){
                throw new IllegalArgumentException("Account number must contain only digits");
            }
        }
        if (accountNumber.trim().length() == 16) {
            this.accountNumber = accountNumber;
        }else{
            throw new IllegalArgumentException("Account number must be 16 characters long");
        }

    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        if(balance < 0){
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = balance;
    }
    public Currency getCurrency() {
        return currency;
    }
    public void setCurrency(Currency currency) {
        if(currency == null){
            throw new IllegalArgumentException("Currency cannot be null");
        }
        this.currency = currency;
    }


}
