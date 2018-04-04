package com.agiledeveloper;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.runner.JUnitPlatform;

import java.util.*;
import java.util.stream.*;

//Start with one test at a time. Uncomment only one test or one assert at a time.
//Run the test, see it fail. Then write minimum code to make that test or assert to pass.
//Once the test passes, move on to the next test/assert.

//import org.junit.runner.RunWith;

//@RunWith(JUnitPlatform.class)
public class SortAssetsTest { 

  List<Asset> assets;
           
  @BeforeEach
  void init() {
    assets = Arrays.asList(
      new Asset("A", 50.0),
      new Asset("B", 30.0),
      new Asset("Z", 20.0),
      new Asset("E", 90.0),
      new Asset("C", 90.0));
  }
       
 @Test
 void compareAssetsBySymbol() {
    Comparator<Asset> comparator = (asset1, asset2) -> asset1.symbol.compareTo(asset2.symbol);

    List<Asset> result = SortAssets.sort(assets, comparator);
  
    List<String> symbols = Arrays.asList("A", "B", "C", "E", "Z");
    IntStream.range(0, symbols.size())
             .forEach(index -> assertEquals(result.get(index).symbol, symbols.get(index)));
 }
                                  
  @Test
  void compareAssetsBySymbolAgain() {
    Comparator<Asset> bySymbol = SortAssets.comparatorBySymbol();
    List<Asset> result = SortAssets.sort(assets, bySymbol);

    List<String> symbols = Arrays.asList("A", "B", "C", "E", "Z");
    IntStream.range(0, symbols.size())
             .forEach(index -> assertEquals(result.get(index).symbol, symbols.get(index)));
  }

  @Test
  void compareAssetsByDescendingOrderOfSymbol() {
    Comparator<Asset> bySymbolDescending = SortAssets.comparatorBySymbolDescending();
    List<Asset> result = SortAssets.sort(assets, bySymbolDescending);

    List<String> symbols = Arrays.asList("Z", "E", "C", "B", "A");
    IntStream.range(0, symbols.size())
             .forEach(index -> assertEquals(result.get(index).symbol, symbols.get(index)));
  }

  @Test
  void compareAssetsByOrderOfAmount() {
    Comparator<Asset> byAmount = SortAssets.comparatorByAmount();
    List<Asset> result = SortAssets.sort(assets, byAmount);

    assertEquals(20.0, result.get(0).amount);
    assertEquals(90.0, result.get(4).amount);
  }

  @Test
  void compareAssetsByDescendingOrderOfAmount() {
    Comparator<Asset> byAmountDescending = SortAssets.comparatorByDescendingOrderOfAmount();
    List<Asset> result = SortAssets.sort(assets, byAmountDescending);

    assertEquals(90.0, result.get(0).amount);
    assertEquals(20.0, result.get(4).amount);
  }

  @Test
  void compareAssetsAmountAndSymbol() {
    List<Asset> result = SortAssets.sort(assets, SortAssets.comparatorByAmountAndSymbol());

    assertEquals(20.0, result.get(0).amount);
    assertEquals(90.0, result.get(3).amount);
    assertEquals(90.0, result.get(4).amount);

    assertEquals("C", result.get(3).symbol);
    assertEquals("E", result.get(4).symbol);
  }
}