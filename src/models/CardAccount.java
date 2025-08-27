package models;

import enums.*;
public class CardAccount {
    private String accountNumber;
    private String cvv;
    private String expirationDate;
    private CardType cardType;
    private double balance;
    private CardStatus cardStatus;
    private Currency currency;
    public CardAccount(String accountNumber, String cvv, String expirationDate, CardType cardType, double balance, CardStatus cardStatus, Currency currency) {

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
    public String getCvv() {
        return cvv;
    }
    public void setCvv(String cvv) {
        if(cvv == null || cvv.isEmpty()){
            throw new IllegalArgumentException("CVV cannot be null or empty");
        }
        if (cvv.length() == 3) {
            this.cvv = cvv;
        }else{
            throw new IllegalArgumentException("CVV must be 3 characters long");
        }
    }
    public String getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(String expirationDate) {
        if(expirationDate == null || expirationDate.isEmpty()){
            throw new IllegalArgumentException("Expiration date cannot be null or empty");
        }
        // Simple validation for MM/YY format
        if (expirationDate.matches("(0[1-9]|1[0-2])/[0-9]{2}")) {
            this.expirationDate = expirationDate;
        }else{
            throw new IllegalArgumentException("Expiration date must be in MM/YY format");
        }
    }

}
