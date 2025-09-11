package test;

import enums.*;
import model.*;
import transaction.*;
import transaction.impl.*;

public class Test {
    public static void main(String[] args) {
        Bank bank1 = new Bank("Bank A", new Address("Armenia", "Yerevan", "Yerevan", "Main St", "1"));
        Bank bank2 = new Bank("Bank B", new Address("USA", "California", "Los Angeles", "Sunset Blvd", "100"));
        System.out.println(bank1.toString());
        System.out.println(bank2.toString());
        BankAccount bankAccount1 = new BankAccount("1234567891011123", Currency.AMD, BankAccountType.DEBIT);
        BankAccount bankAccount2 = new BankAccount("1234567891011133", Currency.AMD, BankAccountType.DEBIT);
        BankAccount bankAccount3 = new BankAccount("1234567891011163", Currency.USD, BankAccountType.CREDIT);
        BankAccount bankAccount4 = new BankAccount("1234567891014133", Currency.USD, BankAccountType.CREDIT);


        CardHolder man1 = new CardHolder("John", "Doe", new Address("Armenia", "Yerevan", "Yerevan", "Main St", "1"), bankAccount1);
        CardHolder man2 = new CardHolder("John", "Doe", new Address("Armenia", "Yerevan", "Yerevan", "Main St", "1"), bankAccount2);
        CardHolder man3 = new CardHolder("John", "Doe", new Address("USA", "California", "Los Angeles", "Sunset Blvd", "100"), bankAccount3);
        CardHolder man4 = new CardHolder("John", "Doe", new Address("USA", "California", "Los Angeles", "Sunset Blvd", "100"), bankAccount4);


        CardAccount card1 = new CardAccount("1234567891011123", "856", CardType.VISA, Currency.AMD);
        CardAccount card2 = new CardAccount("1234567881011123", "457", CardType.MASTERCARD, Currency.AMD);
        CardAccount card3 = new CardAccount("1234567896011123", "999", CardType.AMERICAN_EXPRESS, Currency.AMD);
        CardAccount card4 = new CardAccount("1234567811011123", "034", CardType.VISA, Currency.AMD);
    }
}
