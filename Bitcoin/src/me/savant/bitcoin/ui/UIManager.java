package me.savant.bitcoin.ui;

import me.savant.bitcoin.cex.CexAPI;

public class UIManager
{
	boolean isLoading = true;
	Loading loading;
	Window window;
	public UIManager(CexAPI cex)
	{
		loading = new Loading();
		window = new Window(cex);
	}
	
	public boolean isLoading()
	{
		return isLoading;
	}
	
	public Window getWindow()
	{
		return window;
	}
	
	public Loading getLoading()
	{
		return loading;
	}
	
	public void progress()
	{
		if(isLoading())
			loading.progress();
	}
	
	public void doneLoading()
	{
		isLoading = false;
		loading.close();
		window.setVisible(true);
	}
}
