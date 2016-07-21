package me.savant.bitcoin;

public class Bitcoin
{
	static BTCPrice price;
	
	public static void main(String[] args)
	{
		Window window = new Window();

		price = new BTCPrice(window);
	}
}
