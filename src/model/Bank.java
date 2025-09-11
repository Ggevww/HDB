package model;

/**
 * Bank class represents a bank with its name, address, and associated card holders.
 */
public class Bank {
    private String bankName;
    private Address address;
    private CardHolder[] cardHolders;

    /**
     * Constructs a Bank object with the specified name and address.
     *
     * @param bankName the name of the bank
     * @param address  the address of the bank
     */
    public Bank(String bankName, Address address) {
        setBankName(bankName);
        setAddress(address);
        this.cardHolders = new CardHolder[0];
    }
    /** Getters and Setters */
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        if (bankName == null || bankName.isEmpty()) {
            throw new IllegalArgumentException("Bank name cannot be null or empty");
        }
        this.bankName = bankName;
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
    /** Card Holders Management */
    public CardHolder[] getCardHolders() {
        return cardHolders;
    }
    public void addCardHolder(CardHolder cardHolder) {
        if (cardHolder == null) {
            throw new IllegalArgumentException("Card holder cannot be null");
        }
        CardHolder[] newCardHolders = new CardHolder[cardHolders.length + 1];
        System.arraycopy(cardHolders, 0, newCardHolders, 0, cardHolders.length);
        newCardHolders[cardHolders.length] = cardHolder;
        cardHolders = newCardHolders;
    }
    public void printCardHolders() {
        if (cardHolders.length == 0) {
            System.out.println("No card holders available");
        } else {
            for (CardHolder cardHolder : cardHolders) {
                System.out.println(cardHolder.toString());
            }
        }
    }
    @Override
    public String toString() {
        return "Bank: " +
                "bank name='" + bankName + '\'' +
                ", address=" + address +
                ", cardHolders=" + cardHolders.length;

    }



}
