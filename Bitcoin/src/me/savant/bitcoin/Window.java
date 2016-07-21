package me.savant.bitcoin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Window
{
	private JFrame frame;

	public Window()
	{
		initialize();
		frame.setVisible(true);
	}
	
	JLabel price;
	JLabel priceYestrday;
	JLabel difference;
	
	public void updatePrice(float price, float priceYesterday, String difference)
	{
		this.price.setText(price + "");
		this.priceYestrday.setText(priceYesterday + "");
		
		this.difference.setText(difference + " BTC");
		if(difference.contains("+"))
		{
			this.difference.setForeground(new Color(34, 139, 34));
		}
		else
		{
			this.difference.setForeground(new Color(255, 0, 0));
		}
		this.price.revalidate();
		this.price.repaint();
		frame.revalidate();
		frame.repaint();
	}
	
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 49, 444, 312);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Settings", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Console", null, panel_1, null);
		
		JLabel Label_price = new JLabel("BTC Price (USD):");
		Label_price.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_price.setBounds(10, 0, 119, 29);
		frame.getContentPane().add(Label_price);
		
		price = new JLabel("Loading");
		price.setFont(new Font("Tahoma", Font.PLAIN, 15));
		price.setBounds(126, 2, 84, 27);
		frame.getContentPane().add(price);
		
		JLabel Label_priceYesterday = new JLabel("Yesterday:");
		Label_priceYesterday.setHorizontalAlignment(SwingConstants.RIGHT);
		Label_priceYesterday.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Label_priceYesterday.setBounds(20, 24, 84, 14);
		frame.getContentPane().add(Label_priceYesterday);
		
		priceYestrday = new JLabel("Loading");
		priceYestrday.setFont(new Font("Tahoma", Font.PLAIN, 12));
		priceYestrday.setBounds(107, 24, 46, 14);
		frame.getContentPane().add(priceYestrday);
		
		difference = new JLabel("Loading");
		difference.setForeground(new Color(34, 139, 34));
		difference.setFont(new Font("Tahoma", Font.PLAIN, 15));
		difference.setBounds(186, 0, 159, 29);
		frame.getContentPane().add(difference);
		
		JLabel PoweredByCoindesk = new JLabel("Powered by CoinDesk");
		PoweredByCoindesk.setHorizontalAlignment(SwingConstants.RIGHT);
		PoweredByCoindesk.setBounds(300, 0, 141, 14);
		frame.getContentPane().add(PoweredByCoindesk);
	}
}
