package models;

import enums.Currency;

public class Account {
    private String accountNumber;
    private double balance;
    private Currency currency;
    public Account(String accountNumber, double balance, Currency currency) {
        setAccountNumber(accountNumber);
        setBalance(balance);
        setCurrency(currency);
    }
    public Account(String accountNumber, Currency currency) {
        setAccountNumber(accountNumber);
        setBalance(0);
        setCurrency(currency);
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    private void setAccountNumber(String accountNumber){
        if(accountNumber == null || accountNumber.isEmpty()){
            throw new IllegalArgumentException("Account number cannot be null or empty");
        }
        if (accountNumber.length() == 16) {
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
