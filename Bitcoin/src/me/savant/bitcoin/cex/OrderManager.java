package me.savant.bitcoin.cex;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class OrderManager
{
	public int minimumSize = 13;
	
	CexAPI cex;
	public OrderManager(CexAPI cex)
	{
		this.cex = cex;
	}
	
	public List<OrderIndex> fetchOrders()
	{
		List<OrderIndex> list = new ArrayList<OrderIndex>();
		if(cex.isConnected())
		{	
			String json = cex.openOrders("BTC/USD");
			JsonParser jp = new JsonParser();
			JsonElement root = jp.parse(json);
			JsonArray array = root.getAsJsonArray();
			for(int i = 0; i < array.size(); i++)
			{
				JsonElement element = array.get(i);
				int tradeID = element.getAsJsonObject().get("id").getAsInt();
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
				int date = element.getAsJsonObject().get("time").getAsInt();
				int pending = element.getAsJsonObject().get("pending").getAsInt();
				list.add(new OrderIndex(tradeID, type, amount, price, date, pending));
			}
		}
		else
		{
			System.out.println("Not Connected");
		}
		return list;
	}
}
