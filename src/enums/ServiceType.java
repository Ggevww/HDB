package enums;

/**
 * Enumeration representing different types of services offered.
 */
public enum ServiceType {

    ACCOUNT_OPENING("Account opening"),
    LOAN_CONSULTING("Loan consulting"),
    CARD_ISSUE("Card issue");

    String name;

    ServiceType(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }


}
