package me.savant.bitcoin.cex;

import me.savant.bitcoin.Index;

public class OrderIndex extends Index
{
	int pending;
	
	public OrderIndex(int tradeID, OrderType type, float amount, float price, int date, int pending)
	{
		super(tradeID, type, amount, price, date);
		this.pending = pending;
	}
	
	public int getPending()
	{
		return pending;
	}
}
