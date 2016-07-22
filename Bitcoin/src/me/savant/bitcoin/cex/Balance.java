package me.savant.bitcoin.cex;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Balance
{
	//{"timestamp":"1469207242","username":"up102956815","BTC":{"available":"0.00000000","orders":"0.00000000"},"USD":{"available":"0.00","orders":"0.00"},"EUR":{"available":"0.00","orders":"0.00"},"GHS":{"available":"0.00000000","orders":"0.00000000"},"LTC":{"available":"0.00000000","orders":"0.00000000"},"RUB":{"available":"0.00","orders":"0.00"},"ETH":{"available":"0.00000000","orders":"0.00000000"}}
	
	CexAPI cex;
	public Balance(CexAPI cex)
	{
		this.cex = cex;
	}
	
	public float getBTCBalance()
	{
		if(!cex.isConnected())
			return -1f;
		JsonParser jp = new JsonParser();
		String json = cex.balance();
		JsonElement root = jp.parse(json);
		System.out.println(json);
		return root.getAsJsonObject().get("BTC").getAsJsonObject().get("available").getAsFloat();
	}
	
	public float getUSDBalance()
	{
		if(!cex.isConnected())
			return -1f;
		JsonParser jp = new JsonParser();
		String json = cex.balance();
		JsonElement root = jp.parse(json);
		JsonObject rt = root.getAsJsonObject();
		System.out.println(json);
		JsonObject usd = rt.get("USD").getAsJsonObject();
		return usd.get("available").getAsFloat();
	}
}
