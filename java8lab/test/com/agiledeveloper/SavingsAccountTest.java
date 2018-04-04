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
public class SavingsAccountTest  implements AccountTest  {
  
  @Test
  void withdrawDropsBalanceBelowMiniumBalance() {

    Account account = new SavingsAccount("12345678", 300000, 100000);

    Exception ex = assertThrows(InvalidOperationException.class, () -> account.withdraw(250000));

    assertEquals("Balance should not drop below required minimum", ex.getMessage());

  }

    @Override
    public void canaryTest() {
        assertEquals(true,true);
    }

    @Override
      public Account createAccount(String id, int initialBalance) {
        final int minimumBalance = -100;
        return new SavingsAccount(id, initialBalance, minimumBalance);
      }

}