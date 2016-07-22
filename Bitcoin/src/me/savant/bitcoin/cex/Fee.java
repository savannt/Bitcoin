package me.savant.bitcoin.cex;

public class Fee
{
	static float CEXIO_FEE = 0.2f;
	
	public static float getFee(float btcAmount)
	{
		return btcAmount * CEXIO_FEE;
	}
	
	public static float getListingPrice(float btcAmount)
	{
		return btcAmount * (1 + CEXIO_FEE);
	}
}
