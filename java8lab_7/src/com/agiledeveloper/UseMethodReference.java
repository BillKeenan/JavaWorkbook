package com.agiledeveloper;

//Start with the code given below. Refactor each lambda expression to use method reference.

import java.util.*;
import static java.util.stream.Collectors.*;

public class UseMethodReference {
  List<Integer> values = new ArrayList<>();
  static List<Integer> globalValues = new ArrayList<>();
  
  public void storeValue(int number) {
    values.add(number);
  }
  
  public static void storeGlobalValue(int number) {
    globalValues.add(number);
  }
 
  public void storeValues(List<Integer> values) {
    values.forEach(this::storeValue);
  }

  public void storeGlobalValues(List<Integer> values) {
    values.forEach(UseMethodReference::storeGlobalValue);
  }

  public static void storeGlobalValues2(List<Integer> values) {
    values.forEach(UseMethodReference::storeGlobalValue);
  }

  public static List<String> getStringOfValues(List<Integer> values) {
    return values.stream()
      .map(value -> value.toString())
      .collect(toList());
  }
}
