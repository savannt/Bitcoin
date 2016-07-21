package me.savant.bitcoin;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class BTCPrice
{
	public final String API_URL = "http://api.coindesk.com/v1/bpi/currentprice.json";
	public final String OLD_API_URL = "http://api.coindesk.com/v1/bpi/historical/close.json?for=yesterday";
	
	float price = 0;
	float yesterdaysPrice = 0;
	String difference = "";
	
	Window window;
	
	public BTCPrice(Window window)
	{
		this.window = window;
		Thread thread = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				update();
			}
		});
		thread.start();
	}
	
	
	void update()
	{		
		try
		{
			URL url = new URL(API_URL);
			
			HttpURLConnection request = (HttpURLConnection) url.openConnection();
			request.connect();
			JsonParser jp = new JsonParser();
			JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
			price = root.getAsJsonObject().getAsJsonObject("bpi").getAsJsonObject("USD").get("rate").getAsFloat();
			
			request.disconnect();
			
			url = new URL(OLD_API_URL);
			request = (HttpURLConnection) url.openConnection();
			request.connect();
			jp = new JsonParser();
			root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
			yesterdaysPrice = Float.parseFloat(root.getAsJsonObject().getAsJsonObject("bpi").toString().split(":")[1].replace("}", ""));
			
			difference = "-";
			if(price > yesterdaysPrice)
			{
				double increase = roundFloat(price - yesterdaysPrice);
				difference = "+" + increase;
			}
			else
			{
				double decrease = roundFloat(yesterdaysPrice - price);
				difference = "-" + decrease;
			}
			System.out.println("[BTCPrice - USD] Current: " + price + " Yesterday: " + yesterdaysPrice + "  |  " + difference);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		window.updatePrice(price, yesterdaysPrice, difference);
		
		try
		{
			Thread.sleep(5000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		
		update();
	}
	
	private double roundFloat(float value)
	{
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		Number n = value;
		return Double.parseDouble(df.format(n.doubleValue()));
	}
}
