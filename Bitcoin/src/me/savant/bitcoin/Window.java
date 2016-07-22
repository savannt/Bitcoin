package me.savant.bitcoin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Window
{
	private JFrame frame;

	public Window()
	{
		initialize();
	}
	
	public void setVisible(boolean value)
	{
		frame.setVisible(value);
	}
	
	private JLabel price;
	private JLabel priceYestrday;
	private JLabel difference;
	private JLabel cex_price;
	private JLabel discrepancy;
	private JLabel volatility;
	private JTextField name;
	private JTextField api_key;
	private JTextField api_secret;
	
	public void updatePrice(float price, float priceYesterday, String difference, float cex_price, float volatility)
	{
		this.price.setText(price + "");
		this.priceYestrday.setText(priceYesterday + "");
		this.cex_price.setText(cex_price + "");
		this.volatility.setText(volatility + "%");
		this.difference.setText(difference);
		
		float discrepancy = 0f;
		if(price > cex_price)
		{
			discrepancy = price - cex_price;
		}
		else
		{
			discrepancy = cex_price - price;
		}
		this.discrepancy.setText(discrepancy + "");

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
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Settings", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label_name = new JLabel("CEX.IO Name:");
		label_name.setHorizontalAlignment(SwingConstants.RIGHT);
		label_name.setBounds(10, 11, 123, 14);
		panel_1.add(label_name);
		
		JLabel label_api_key = new JLabel("CEX.IO API Key:");
		label_api_key.setHorizontalAlignment(SwingConstants.RIGHT);
		label_api_key.setBounds(10, 36, 123, 14);
		panel_1.add(label_api_key);
		
		JLabel label_api_secret = new JLabel("CEX.IO API Secret:");
		label_api_secret.setHorizontalAlignment(SwingConstants.RIGHT);
		label_api_secret.setBounds(10, 61, 123, 14);
		panel_1.add(label_api_secret);
		
		name = new JTextField();
		name.setText("up102956815");
		name.setBounds(145, 11, 170, 20);
		panel_1.add(name);
		name.setColumns(10);
		
		api_key = new JTextField();
		api_key.setText("GDAdyYllI0NJgLsEqD1r6egAgZc");
		api_key.setColumns(10);
		api_key.setBounds(145, 36, 170, 20);
		panel_1.add(api_key);
		
		api_secret = new JTextField();
		api_secret.setText("zGG9AXEgM85Dc3zjhvBqiAHj78");
		api_secret.setColumns(10);
		api_secret.setBounds(145, 61, 170, 20);
		panel_1.add(api_secret);
		
		JButton button_UpdateSettings = new JButton("Update Settings");
		button_UpdateSettings.setBounds(40, 86, 275, 23);
		button_UpdateSettings.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Bitcoin.setCex(name.getText(), api_key.getText(), api_secret.getText());
			}
			
		});
		panel_1.add(button_UpdateSettings);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Console", null, panel, null);
		
		JLabel Label_price = new JLabel("BTC Price (USD):");
		Label_price.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_price.setBounds(10, 9, 119, 29);
		frame.getContentPane().add(Label_price);
		
		price = new JLabel("Loading");
		price.setFont(new Font("Tahoma", Font.PLAIN, 15));
		price.setBounds(126, 9, 84, 27);
		frame.getContentPane().add(price);
		
		JLabel Label_priceYesterday = new JLabel("Yesterday:");
		Label_priceYesterday.setHorizontalAlignment(SwingConstants.RIGHT);
		Label_priceYesterday.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Label_priceYesterday.setBounds(20, 35, 84, 14);
		frame.getContentPane().add(Label_priceYesterday);
		
		priceYestrday = new JLabel("Loading");
		priceYestrday.setFont(new Font("Tahoma", Font.PLAIN, 12));
		priceYestrday.setBounds(107, 35, 46, 14);
		frame.getContentPane().add(priceYestrday);
		
		difference = new JLabel("Loading");
		difference.setHorizontalAlignment(SwingConstants.CENTER);
		difference.setForeground(new Color(0, 0, 0));
		difference.setFont(new Font("Tahoma", Font.PLAIN, 14));
		difference.setBounds(154, 9, 141, 29);
		frame.getContentPane().add(difference);
		
		JLabel PoweredByCoindesk = new JLabel("Powered by CoinDesk");
		PoweredByCoindesk.setHorizontalAlignment(SwingConstants.LEFT);
		PoweredByCoindesk.setBounds(10, 0, 141, 14);
		frame.getContentPane().add(PoweredByCoindesk);
		
		JLabel Label_cex_price = new JLabel("BTC Price (USD):");
		Label_cex_price.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_cex_price.setBounds(266, 9, 119, 29);
		frame.getContentPane().add(Label_cex_price);
		
		JLabel PoweredByCexIO = new JLabel("Powered by CEX.io");
		PoweredByCexIO.setHorizontalAlignment(SwingConstants.RIGHT);
		PoweredByCexIO.setBounds(295, 0, 141, 14);
		frame.getContentPane().add(PoweredByCexIO);
		
		cex_price = new JLabel("Loading");
		cex_price.setHorizontalAlignment(SwingConstants.LEFT);
		cex_price.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cex_price.setBounds(384, 9, 84, 29);
		frame.getContentPane().add(cex_price);
		
		JLabel site_discrepancy = new JLabel("Site Discrepancy:");
		site_discrepancy.setHorizontalAlignment(SwingConstants.RIGHT);
		site_discrepancy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		site_discrepancy.setBounds(266, 35, 104, 14);
		frame.getContentPane().add(site_discrepancy);
		
		discrepancy = new JLabel("Loading");
		discrepancy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		discrepancy.setBounds(373, 35, 46, 14);
		frame.getContentPane().add(discrepancy);
		
		JLabel lblVolatility = new JLabel("Volatility:");
		lblVolatility.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVolatility.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVolatility.setBounds(136, 35, 84, 14);
		frame.getContentPane().add(lblVolatility);
		
		volatility = new JLabel("Loading");
		volatility.setFont(new Font("Tahoma", Font.PLAIN, 12));
		volatility.setBounds(223, 35, 46, 14);
		frame.getContentPane().add(volatility);
	}
}
