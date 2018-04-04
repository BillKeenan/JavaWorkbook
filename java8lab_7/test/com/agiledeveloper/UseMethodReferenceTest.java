package com.agiledeveloper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.runner.JUnitPlatform;

import java.util.*;

//import org.junit.runner.RunWith;

//@RunWith(JUnitPlatform.class)
public class UseMethodReferenceTest {                          
  private UseMethodReference useMethodReference;
  
  @BeforeEach
  void init() {
    UseMethodReference.globalValues.clear();
    useMethodReference = new UseMethodReference();
  }

  @Test
  void storeValues() {
    useMethodReference.storeValues(Arrays.asList(1, 2, 3));
    
    assertEquals(Arrays.asList(1, 2, 3), useMethodReference.values);
  }

  @Test
  void storeGlobalValues() {
    useMethodReference.storeGlobalValues(Arrays.asList(1, 2, 3));
    
    assertEquals(Arrays.asList(1, 2, 3), UseMethodReference.globalValues);
  }

  @Test
  void storeGlobalValues2() {
    UseMethodReference.storeGlobalValues2(Arrays.asList(11, 21, 31));
    
    
    assertEquals(Arrays.asList(11, 21, 31), UseMethodReference.globalValues);
  }

  @Test
  void getStringOfValues() {
    assertEquals(Arrays.asList("11", "21", "31"), 
      UseMethodReference.getStringOfValues(Arrays.asList(11, 21, 31)));
  }
}
