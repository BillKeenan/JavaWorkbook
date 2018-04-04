package com.agiledeveloper;

public abstract  class Account {

    private final String id;
    private int balanceInCents;

    public Account(String id, int initialBalance){

        this.id = id;
        this.balanceInCents = initialBalance;

    }

    /**
     *
     * @param amountInCents
     * @throws InvalidOperationException
     */
    public void withdraw(int amountInCents) throws InvalidOperationException {

        if (getBalanceInCents() < amountInCents ){
            throw new InvalidOperationException("Insufficient balance");
        }

        balanceInCents -=amountInCents;
    }

    public String getId() {
        return id;
    }

    public int getBalanceInCents() {
        return balanceInCents;
    }

    public void deposit(int i) {
        balanceInCents += i;
    }
}