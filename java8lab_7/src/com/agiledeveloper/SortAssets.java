package com.agiledeveloper;

import java.util.*;
import static java.util.Comparator.*;

public class SortAssets {

    public static List<Asset> sort(List<Asset> assets, Comparator<Asset> comparator) {
        assets.sort(comparator);
        return  assets;
    }

    public static Comparator<Asset> comparatorBySymbol() {
        return comparing(asset -> asset.symbol);
    }

    public static Comparator<Asset> comparatorBySymbolDescending() {
        return comparatorBySymbol().reversed();
    }

    public static Comparator<Asset> comparatorByAmount() {
        return comparing(asset -> asset.amount);
    }

    public static Comparator<Asset> comparatorByDescendingOrderOfAmount() {
        return comparatorByAmount().reversed();
    }

    public static Comparator<Asset> comparatorByAmountAndSymbol() {
        return comparatorByAmount().thenComparing(comparatorBySymbol());
    }
}
