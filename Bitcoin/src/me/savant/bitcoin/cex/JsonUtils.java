package me.savant.bitcoin.cex;

public class JsonUtils
{
	public static boolean isInvalid(String json)
	{
		if(json.contains("Invalid"))
		{
			System.out.println("Found Invalid Signature");
			return true;
		}
		return false;
	}
	
	public static boolean isNonIncremental(String json)
	{
		if(json.contains("Nonce"))
		{
			System.out.println("Found Non Incremental");
			return true;
		}
		return false;
	}
	
	public static boolean isNotConnected(String json)
	{
		if(json.contains("Not Connected"))
		{
			System.out.println("Found Not Connected");
			return true;
		}
		return false;
	}
	
	public static boolean isNotCorrect(String json)
	{
		if(isInvalid(json) || isNonIncremental(json) || isNotConnected(json))
			return true;
		return false;
	}
}
