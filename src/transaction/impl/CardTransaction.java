package transaction.impl;

import enums.CardStatus;
import exception.BankTransactionException;
import exception.InsufficientFundsException;
import model.CardAccount;
import transaction.Transaction;

/**
 * CardTransaction class implements the Transaction interface to handle deposits, withdrawals, and transfers for a CardAccount.
 */
public class CardTransaction implements Transaction {
    private final CardAccount card;

    public CardTransaction(CardAccount card){
        this.card = card;
    }
    private void validateCardActive() throws BankTransactionException {
        if (card.getCardStatus() == CardStatus.BLOCKED || card.getCardStatus() == CardStatus.CLOSED) {
            throw new BankTransactionException("Card is blocked or closed");
        }
    }

    @Override
    public void deposit(double amount) throws BankTransactionException{
        if(amount <= 0){
            throw new BankTransactionException("Amount must be greater than zero");
        }
        validateCardActive();

        card.setBalance(card.getBalance() + amount);
    }
    @Override
    public void withdraw(double amount) throws BankTransactionException, InsufficientFundsException{
        if(amount <= 0){
            throw new BankTransactionException("Amount must be greater than zero");
        }
        validateCardActive();
        if(card.getBalance() < amount){
            throw new InsufficientFundsException("Insufficient balance");
        }
        card.setBalance(card.getBalance() - amount);
    }

    @Override
    public void transfer(CardAccount toCard, double amount) throws BankTransactionException, InsufficientFundsException{
        if (amount <= 0) {
            throw new BankTransactionException("Amount must be greater than zero");
        }
        validateCardActive();
        if (toCard.getCardStatus() == enums.CardStatus.BLOCKED || toCard.getCardStatus() == enums.CardStatus.CLOSED) {
            throw new BankTransactionException("To card is blocked or closed");
        }
        if (card.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient balance");
        }
        card.setBalance(card.getBalance() - amount);
        toCard.setBalance(toCard.getBalance() + amount);

    }
}
