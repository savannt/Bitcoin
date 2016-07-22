package me.savant.bitcoin.cex;

public class Fee
{
	public static float CEXIO_FEE = 0.02f;
	
	public static float getFee(float btcAmount)
	{
		return btcAmount * CEXIO_FEE;
	}
	
	public static float getListingPrice(float btcAmount)
	{
		return btcAmount * (1 + CEXIO_FEE);
	}
}
