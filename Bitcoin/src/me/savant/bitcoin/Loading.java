package me.savant.bitcoin;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JProgressBar;

public class Loading
{

	private JFrame frame;
	
	public Loading()
	{
		initialize();
		frame.setVisible(true);
		Thread thread = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				animateProgressBar();
			}
		});
		thread.start();
	}
	
	public void close()
	{
		frame.setVisible(false);
		frame.dispose();
	}
	
	JProgressBar progressBar;
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 334, 99);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel loadingLabel = new JLabel("Loading live BTC data and statistics!");
		loadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loadingLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		loadingLabel.setBounds(10, 2, 318, 31);
		frame.getContentPane().add(loadingLabel);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(10, 30, 298, 20);
		frame.getContentPane().add(progressBar);
	}
	
	public void progress()
	{
		progressBar.setValue(progressBar.getValue() + 10);
	}
	
	void animateProgressBar()
	{
		try
		{
			Thread.sleep(300);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		progressBar.setValue(progressBar.getValue() + 1);
		if(progressBar.getValue() < progressBar.getMaximum());
			animateProgressBar();
	}
}
