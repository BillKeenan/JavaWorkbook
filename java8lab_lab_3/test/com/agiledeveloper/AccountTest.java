package com.agiledeveloper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.runner.JUnitPlatform;

import java.util.*;

//Start with one test at a time. Uncomment only one test or one assert at a time.
//Run the test, see it fail. Then write minimum code to make that test or assert to pass.
//Once the test passes, move on to the next test/assert.


//import org.junit.runner.RunWith;

//@RunWith(JUnitPlatform.class)
public class AccountTest {

    private Account account;
//  Account account;
  
  @Test
  void canaryTest() {
    assertTrue(true);
  }
  
  @BeforeEach
  void init() {
    account = new Account("12345678", 10000);
  }

  @Test
  void createAnAccount() {
    assertEquals("12345678", account.getId());
    assertEquals(10000, account.getBalanceInCents());

    assertEquals(0, account.getTransactions().size());
  }
  
  @Test
  void depositAmount() {
    account.deposit(20010);

    assertEquals(30010, account.getBalanceInCents());

    List<Transaction> transactions = account.getTransactions();

    assertEquals(1, transactions.size());

    Transaction transaction = transactions.get(0);

    assertEquals("deposit", transaction.getType());
    assertEquals(20010, transaction.getAmount());
    assertEquals(10000, transaction.getBalanceBefore());
    assertEquals(30010, transaction.getBalanceAfter());
  }
  
  @Test
  void withdrawAmount() throws InvalidOperationException {
    account.withdraw(5025);

    assertEquals(4975, account.getBalanceInCents());

    List<Transaction> transactions = account.getTransactions();
    assertEquals(1, transactions.size());

    Transaction transaction = transactions.get(0);

    assertEquals("withdraw", transaction.getType());
    assertEquals(5025, transaction.getAmount());
    assertEquals(10000, transaction.getBalanceBefore());
    assertEquals(4975, transaction.getBalanceAfter());
  }

  @Test
  void withdrawCurrentBalance() throws InvalidOperationException {
    account.deposit(10000);
    account.withdraw(20000);

    assertEquals(0, account.getBalanceInCents());

    List<Transaction> transactions = account.getTransactions();
    assertEquals(2, transactions.size());

    Transaction transaction = transactions.get(1);

    assertEquals("withdraw", transaction.getType());
    assertEquals(20000, transaction.getAmount());
    assertEquals(20000, transaction.getBalanceBefore());
    assertEquals(0, transaction.getBalanceAfter());
  }
  
  @Test
  void withdrawMoreThanCurrentBalance() {
    Exception ex = assertThrows(InvalidOperationException.class, () -> account.withdraw(20000));

    assertEquals("Insufficient balance", ex.getMessage());

    List<Transaction> transactions = account.getTransactions();
    assertEquals(1, transactions.size());

    Transaction transaction = transactions.get(0);

    assertEquals("Insufficient balance", transaction.getType());
    assertEquals(20000, transaction.getAmount());
    assertEquals(10000, transaction.getBalanceBefore());
    assertEquals(10000, transaction.getBalanceAfter());
  }

    @Test
    void bonus() throws InvalidOperationException {
        account.deposit(10000);
        account.withdraw(5000);

        List<Transaction> transactions = account.getTransactions();

        assertThrows(UnsupportedOperationException.class,() ->transactions.remove(0));
    }
//Bonus work: Write a test where we call deposit and withdraw once. Get the transactions list,
//delete the first transaction from the list and verify that delete operation fails.

}
