package me.savant.bitcoin.cex;

import me.savant.bitcoin.Index;

public class HistoryIndex extends Index
{
	public HistoryIndex(int tradeID, OrderType type, float amount, float price, int date)
	{
		super(tradeID, type, amount, price, date);
	}
}
