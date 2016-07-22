package me.savant.bitcoin.cex;

public class HistoryIndex
{
	private int tradeID;
	private OrderType type;
	private float amount;
	private float price;

	public HistoryIndex(int tradeID, OrderType type, float amount, float price)
	{
		this.tradeID = tradeID;
		this.type = type;
		this.amount = amount;
		this.price = price;
	}
	
	public int getTradeID()
	{
		return tradeID;
	}
	
	public OrderType getType()
	{
		return type;
	}
	
	public float getAmount()
	{
		return amount;
	}
	
	public float getPrice()
	{
		return price;
	}	
}
