package model;

import enums.*;

import java.time.LocalDate;

/**
 * CardAccount class represents a card account with account number, CVV, expiration date, card type, balance, card status, and currency.
 */
public class CardAccount extends Account{
    private String accountNumber;
    private String cvv;
    private LocalDate expirationDate;
    private CardType cardType;
    private double balance;
    private CardStatus cardStatus;
    private Currency currency;

    /** Constructors */
    public CardAccount(String accountNumber, String cvv, String expirationDate, CardType cardType, double balance, Currency currency) {
        super(accountNumber, balance, currency);
        setCvv(cvv);
        setExpirationDate(LocalDate.parse(expirationDate));
        setCardType(cardType);
        setCardStatus(CardStatus.ACTIVE);
    }
    public CardAccount(String accountNumber, String cvv, String expirationDate, CardType cardType, Currency currency) {
        super(accountNumber, 0, currency);
        setCvv(cvv);
        setExpirationDate(LocalDate.parse(expirationDate));
        setCardType(cardType);
        setCardStatus(CardStatus.ACTIVE);
    }
    public CardAccount(String accountNumber, String cvv, CardType cardType, Currency currency) {
        super(accountNumber, 0, currency);
        setAccountNumber(accountNumber);
        setCvv(cvv);
        setExpirationDate(LocalDate.now().plusYears(5));
        setCardType(cardType);
        setCardStatus(CardStatus.ACTIVE);
    }
    public CardAccount(String accountNumber, String cvv, CardType cardType, double balance, Currency currency) {
        super(accountNumber, balance, currency);
        setAccountNumber(accountNumber);
        setCvv(cvv);
        setExpirationDate(LocalDate.now().plusYears(5));
        setCardType(cardType);
        setCardStatus(CardStatus.ACTIVE);
    }

    /** Getters and Setters */
    public String getCvv() {
        return cvv;
    }
    public void setCvv(String cvv) {
        if(cvv == null || cvv.isEmpty()){
            throw new IllegalArgumentException("CVV cannot be null or empty");
        }
        if (cvv.trim().length() == 3) {
            this.cvv = cvv;
        }else{
            throw new IllegalArgumentException("CVV must be 3 characters long");
        }
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(LocalDate expirationDate) {
        if(expirationDate == null){
            throw new IllegalArgumentException("Expiration date cannot be null");
        }
        if (expirationDate .isAfter(LocalDate.now())) {
            this.expirationDate = expirationDate;
        }
        else{
            throw new IllegalArgumentException("Expiration date must be in MM/YY format");
        }
    }
    public CardType getCardType() {
        return cardType;
    }
    public void setCardType(CardType cardType) {
        if(cardType == null){
            throw new IllegalArgumentException("Card type cannot be null");
        }
        this.cardType = cardType;
    }
    public CardStatus getCardStatus() {
        return cardStatus;
    }
    public void setCardStatus(CardStatus cardStatus) {
        if(cardStatus == null){
            throw new IllegalArgumentException("Card status cannot be null");
        }
        this.cardStatus = cardStatus;
    }

    @Override
    public String toString() {
        return "CardAccount: " +
                "accountNumber='" + getAccountNumber() + '\'' +
                ", expirationDate=" + expirationDate +
                ", cardType=" + cardType +
                ", balance=" + getBalance() +
                ", cardStatus=" + cardStatus +
                ", currency=" + getCurrency();
    }



}
