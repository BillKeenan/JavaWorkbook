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
public class CheckingAccountTest implements AccountTest  {
  public Account createAccount(String id, int initialBalance) {
    return new CheckingAccount(id, initialBalance);
  }
}