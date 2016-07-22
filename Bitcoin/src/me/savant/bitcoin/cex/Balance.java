package me.savant.bitcoin.cex;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Balance
{	
	CexAPI cex;
	public Balance(CexAPI cex)
	{
		this.cex = cex;
	}
	
	public float getBalance(String currency)
	{
		if(!cex.isConnected())
			return -1f;
		JsonParser jp = new JsonParser();
		String json = cex.balance();
		JsonElement root = jp.parse(json);
		return root.getAsJsonObject().get(currency).getAsJsonObject().get("available").getAsFloat();
	}
}
