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
public interface AccountTest {
  @Test
  default void canaryTest() {
    assertTrue(true);
  }

  Account createAccount(String id, int initialBalance);
//
  @Test
  default void createAnAccount() {
    Account account = createAccount("12345678", 10000);

    assertEquals("12345678", account.getId());
    assertEquals(10000, account.getBalanceInCents());
  }

  @Test
  default void depositAmount() {
    Account account = createAccount("12345678", 10000);

    account.deposit(20010);

    assertEquals(30010, account.getBalanceInCents());
  }
  
  @Test
  default void withdrawAmount() throws InvalidOperationException {
    Account account = createAccount("12345678", 10000);

    account.withdraw(5025);

    assertEquals(4975, account.getBalanceInCents());
  }

  @Test
  default void withdrawCurrentBalance() throws InvalidOperationException {
    Account account = createAccount("12345678", 10000);

    account.withdraw(10000);

    assertEquals(0, account.getBalanceInCents());
  }
  
  @Test
  default void withdrawMoreThanCurrentBalance() {
    Account account = createAccount("12345678", 10000);

    Exception ex = assertThrows(InvalidOperationException.class, () -> account.withdraw(10001));

    assertEquals("Insufficient balance", ex.getMessage());
  }
}