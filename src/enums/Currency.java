package enums;

public enum Currency {
    AMD(0.05),
    USD(0.03),
    RUB(0.04);

    private double interestRate;

    Currency(double interestRate){
        this.interestRate = interestRate;
    }
    /**
     * Returns the interest rate associated with the currency.
     *
     * @return the interest rate
     */
    public double getInterestRate() {
        return interestRate;
    }

}
