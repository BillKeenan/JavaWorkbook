package com.agiledeveloper;

public class Asset {
	public final String symbol;
	public final double amount;
	
	public Asset(String theSymbol, double theAmount) {
	  symbol = theSymbol;
	  amount = theAmount;
	}
	
	public String toString() { return String.format("%s %g", symbol, amount); }
}