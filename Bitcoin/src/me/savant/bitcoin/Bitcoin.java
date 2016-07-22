package me.savant.bitcoin;

import me.savant.bitcoin.cex.CexAPI;
import me.savant.bitcoin.ui.UIManager;

public class Bitcoin
{
	/**
	 * CEX.IO
	 * 
	 * Buying - Buy Low
	 * Selling - Sell High
	 * 
	 * ask - sell
	 * bid - buy
	 */
	
	static BTCStats price;
	static CexAPI cex;
	
	public static void main(String[] args)
	{
		cex = new CexAPI("", "", "");
		UIManager manager = new UIManager(cex);
		price = new BTCStats(manager, cex);
	}
	
	public static void setCex(String name, String apiKey, String apiSecret)
	{
		cex.updateSettings(name, apiKey, apiSecret);
	}
}
