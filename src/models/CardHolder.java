package models;

/**
 * CardHolder class represents a card holder with passport number, full name, address, associated card accounts, and a bank account.
 */
public class CardHolder {
    private String passportNumber;
    private String fullName;
    private Address address;
    private CardAccount[] cardList;
    private BankAccount bankAccount;

    /** Constructors */
    public CardHolder(String passportNumber, String fullName, Address address, BankAccount bankAccount) {
        setPassportNumber(passportNumber);
        setFullName(fullName);
        setAddress(address);
        setBankAccount(bankAccount);
        this.cardList = new CardAccount[0];
    }
    public CardHolder(String passportNumber, String fullName, Address address, BankAccount bankAccount, CardAccount card) {
        setPassportNumber(passportNumber);
        setFullName(fullName);
        setAddress(address);
        setBankAccount(bankAccount);
        this.cardList = new CardAccount[1];
        this.cardList[0] = card;
    }
    /** Getters and Setters */

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        if (passportNumber == null || passportNumber.isEmpty()) {
            throw new IllegalArgumentException("Passport number cannot be null or empty");
        }
        if (passportNumber.trim().length() == 9 && Character.isLetter(passportNumber.trim().charAt(0)) && Character.isLetter(passportNumber.trim().charAt(1)) && passportNumber.trim().substring(2).chars().allMatch(Character::isDigit)) {
            this.passportNumber = passportNumber;
        } else {
            throw new IllegalArgumentException("Passport number must be 9 characters long and start with two letters followed by 7 digits");
        }
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        if (fullName == null || fullName.isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be null or empty");
        }
        this.fullName = fullName;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        this.address = address;
    }
    public void printAddress() {
        System.out.println(address.toString());
    }
    public CardAccount[] getCardList() {
        return cardList;
    }
    public void printCardList() {
        if (cardList.length == 0) {
            System.out.println("No cards available");
        } else {
            for (CardAccount card : cardList) {
                System.out.println(card.toString());
            }
        }
    }
    /** Adds a new CardAccount to the cardList array */
    public void addCard(CardAccount card) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null");
        }
        CardAccount[] newCardList = new CardAccount[cardList.length + 1];
        System.arraycopy(cardList, 0, newCardList, 0, cardList.length);
        newCardList[cardList.length] = card;
        cardList = newCardList;
    }
    public BankAccount getBankAccount() {
        return bankAccount;
    }
    public void setBankAccount(BankAccount bankAccount) {
        if (bankAccount == null) {
            throw new IllegalArgumentException("Bank account cannot be null");
        }
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "CardHolder: " +
                "passportNumber='" + passportNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address=" + address +
                ", bankAccount=" + bankAccount;
    }
}