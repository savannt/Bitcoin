package me.savant.bitcoin;

public class Bitcoin
{
	/**
	 * CEX.IO
	 * 
	 * Buying - Buy Low
	 * Selling - Sell High
	 * 
	 */
	
	static BTCStats price;
	static CexAPI cex;
	
	public static void main(String[] args)
	{
		Window window = new Window();
		cex = new CexAPI("", "", "");
		price = new BTCStats(window, cex);
	}
	
	public static void setCex(String name, String apiKey, String apiSecret)
	{
		cex = new CexAPI(name, apiKey, apiSecret);
	}
}
