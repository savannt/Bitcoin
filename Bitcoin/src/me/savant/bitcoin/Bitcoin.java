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
		UIManager manager = new UIManager();
		cex = new CexAPI("", "", "");
		price = new BTCStats(manager, cex);
	}
	
	public static void setCex(String name, String apiKey, String apiSecret)
	{
		cex = new CexAPI(name, apiKey, apiSecret);
	}
}
