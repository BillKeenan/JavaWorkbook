package com.agiledeveloper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.runner.JUnitPlatform;

import java.util.*;

//Start with one test at a time. Uncomment only one test or one assert at a time.
//Run the test, see it fail. Then write minimum code to make that test or assert to pass.
//Once the test passes, move on to the next test/assert.


class Base implements Comparable<Base> {
  public int compareTo(Base b) { return 0; }
}

class Derived extends Base implements Comparable<Base> {
  public int compareTo(Base d) { return 0; }
}

//import org.junit.runner.RunWith;

//@RunWith(JUnitPlatform.class)
public class PairTest {                          
  @Test
  void canaryTest() {
    assertTrue(true);
  }

  @Test
  void createAPairOfInt() {
    Pair<Integer> pair = new Pair<Integer>(1, 2);

    assertAll(
      () -> assertEquals(1, (int) pair.getLeft()),
      () -> assertEquals(2, (int) pair.getRight()));
  }

  @Test
  void changeValuesInAPairOfInt() {
    Pair<Integer> pair = new Pair<Integer>(1, 2);

    pair.setLeft(4);
    pair.setRight(5);

    assertAll(
      () -> assertEquals(4, (int) pair.getLeft()),
      () -> assertEquals(5, (int) pair.getRight()));
  }

  @Test
  void createAPairOfString() {
    Pair<String> pair = new Pair<String>("Jack", "Jill");

    assertAll(
      () -> assertEquals("Jack", pair.getLeft()),
      () -> assertEquals("Jill", pair.getRight()));
  }

  @Test
  void changeValuesInAPairOfString() {
    Pair<String> pair = new Pair<String>("Jack", "Jill");

    pair.setLeft("Tom");
    pair.setRight("Jerry");

    assertAll(
      () -> assertEquals("Tom", pair.getLeft()),
      () -> assertEquals("Jerry", pair.getRight()));
  }

  @Test
  void createAPairOfBase() {
    Base base1 = new Base();
    Base base2 = new Base();
    Pair<Base> pair = new Pair<Base>(base1, base2);

    assertAll(
      () -> assertEquals(base1, pair.getLeft()),
      () -> assertEquals(base2, pair.getRight()));
  }

  @Test
  void changeValuesInAPairOfBase() {
    Pair<Base> pair = new Pair<Base>(new Base(), new Base());

    Derived derived1 = new Derived();
    Derived derived2 = new Derived();
    pair.setLeft(derived1);
    pair.setRight(derived2);

    assertAll(
      () -> assertEquals(derived1, pair.getLeft()),
      () -> assertEquals(derived2, pair.getRight()));
  }

  @Test
  void copyPairOfInt() {
    Pair<Integer> pair1 = new Pair<Integer>(1, 2);
    Pair<Integer> pair2 = new Pair<Integer>(3, 4);

    pair1.copyFrom(pair2);
    assertAll(
      () -> assertEquals(3, (int) pair1.getLeft()),
      () -> assertEquals(4, (int) pair1.getRight()));
  }

  @Test
  void copyFromPairOfDerived() {
    Derived derived1 = new Derived();
    Derived derived2 = new Derived();

    Pair<Base> pair1 = new Pair<Base>(new Base(), new Base());
    Pair<Derived> pair2 = new Pair<Derived>(derived1, derived2);

    pair1.copyFrom(pair2);
    assertAll(
      () -> assertEquals(derived1, pair1.getLeft()),
      () -> assertEquals(derived2, pair1.getRight()));
  }

  @Test
  void copyFromPairOfNumberShouldResultInError() {
    Pair<Derived> pair1 = new Pair<Derived>(new Derived(), new Derived());
    Pair<Base> pair2 = new Pair<Base>(new Base(), new Base());

    //pair1.copyFrom(pair2); //Uncommenting this line should result in a compilation error. Verify and leave this line commented out
    assertTrue(true);
  }

  @Test
  void copyToPairOfNumber() {
    Derived derived1 = new Derived();
    Derived derived2 = new Derived();
    Pair<Derived> pair1 = new Pair<Derived>(derived1, derived2);
    Pair<Base> pair2 = new Pair<Base>(new Base(), new Base());

    pair1.copyTo(pair2);
    assertAll(
      () -> assertEquals(derived1, pair2.getLeft()),
      () -> assertEquals(derived2, pair2.getRight()));
  }

  @Test
  void copyToPairOfIntShouldResultInError() {
    Pair<Base> pair1 = new Pair<Base>(new Base(), new Base());
    Pair<Derived> pair2 = new Pair<Derived>(new Derived(), new Derived());

    //pair1.copyTo(pair2); //Uncommenting this line should result in a compilation error. Verify and leave this line commented out
    assertTrue(true);
  }

  @Test
  void pairsAreEqual(){
    Comparable<Pair<Integer>> pair1 = new Pair<Integer>(1, 2);
    Pair<Integer> pair2 = new Pair<Integer>(1, 2);

    assertEquals(0, pair1.compareTo(pair2));
  }

  @Test
  void pairsAreNotEqual(){
    Pair<Integer> pair1 = new Pair<Integer>(1, 2);
    Pair<Integer> pair2 = new Pair<Integer>(1, 0);
    Pair<Integer> pair3 = new Pair<Integer>(1, 3);
    Pair<Integer> pair4 = new Pair<Integer>(2, 2);
    Pair<Integer> pair5 = new Pair<Integer>(0, 2);

    assertAll(
      () -> assertEquals(1, pair1.compareTo(pair2)),
      () -> assertEquals(-1, pair1.compareTo(pair3)),
      () -> assertEquals(-1, pair1.compareTo(pair4)),
      () -> assertEquals(1, pair1.compareTo(pair5))
    );
  }
}
