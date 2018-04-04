package com.agiledeveloper;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//import org.junit.runner.RunWith;

//@RunWith(JUnitPlatform.class)
public class IncrementorTest {
  @Test
  void increment() {
    assertAll(
      () -> assertEquals(0, Incrementor.increment(0)),
      () -> assertEquals(1, Incrementor.increment(1)),
      () -> assertEquals(3, Incrementor.increment(2)),
      () -> assertEquals(6, Incrementor.increment(3))
    );
  }
}

