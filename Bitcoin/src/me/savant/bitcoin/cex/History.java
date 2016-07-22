package me.savant.bitcoin.cex;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class History
{
	public int amount = 25;
	CexAPI cex;
	public History(CexAPI cex)
	{
		this.cex = cex;
	}
		
	public List<HistoryIndex> fetchHistory()
	{
		List<HistoryIndex> list = new ArrayList<HistoryIndex>();
		String json = cex.tradeHistory("BTC/USD", 0);
		
		JsonParser jp = new JsonParser();
		JsonElement root = jp.parse(json);
		JsonArray array = root.getAsJsonArray();
		for(int i = 0; i < array.size(); i++)
		{
			JsonElement element = array.get(i);
			int tradeID = element.getAsJsonObject().get("tid").getAsInt();
			OrderType type = null;
			String sType = element.getAsJsonObject().get("type").getAsString();
			if(sType.equalsIgnoreCase("buy"))
			{
				type = OrderType.BUY;
			}
			else
			{
				type = OrderType.SELL;
			}
			float amount = element.getAsJsonObject().get("amount").getAsFloat();
			float price = element.getAsJsonObject().get("price").getAsFloat();
			int date = element.getAsJsonObject().get("date").getAsInt();
			list.add(new HistoryIndex(tradeID, type, amount, price, date));
		}
		return list;
	}
}
