package com.agiledeveloper;

public class Transaction {
  private String type;
  private int amount;
  private int balanceBefore;
  private int balanceAfter;
  
  public Transaction(String theType, int theAmount, int theBalanceBefore, int theBalanceAfter) {
    type = theType;
    amount = theAmount;
    balanceBefore = theBalanceBefore;
    balanceAfter = theBalanceAfter;
  }                                
  
  public String getType() { return type; }
  public int getAmount() { return amount; }
  public int getBalanceBefore() { return balanceBefore; }
  public int getBalanceAfter() { return balanceAfter; }
}