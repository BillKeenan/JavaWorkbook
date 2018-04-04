package com.agiledeveloper;

public class SavingsAccount extends Account {

    private int minimumBalance;

    public SavingsAccount(String id, int initialBalance, int minimumBalance) {
        super(id, initialBalance);
        this.minimumBalance = minimumBalance;
    }

    @Override
    public void withdraw(int amountInCents) throws InvalidOperationException {

        if (this.getBalanceInCents() - amountInCents < minimumBalance){
            throw new InvalidOperationException("Balance should not drop below required minimum");
        }

        super.withdraw(amountInCents);
    }
}