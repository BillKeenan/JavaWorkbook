package com.agiledeveloper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {

    private final String id;
    private int balanceInCents;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(String id, int initialBalance) {
        this.id = id;
        this.balanceInCents = initialBalance;
    }

    public String getId() {
        return id;
    }

    public int getBalanceInCents() {
        return balanceInCents;
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);

    }

    public void deposit(int i) {

        transactions.add(new Transaction("deposit",i,balanceInCents,balanceInCents+i));
        balanceInCents += i;

    }

    public void withdraw(int i) throws InvalidOperationException {

        if (balanceInCents < i){
            transactions.add(new Transaction("Insufficient balance",i,balanceInCents,balanceInCents));
            throw new InvalidOperationException("Insufficient balance");
        }
        transactions.add(new Transaction("withdraw",i,balanceInCents,balanceInCents-i));
        balanceInCents -= i;
    }
}