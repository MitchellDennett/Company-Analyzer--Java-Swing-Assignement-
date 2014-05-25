package companyanalyzer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class viewCompanyGraph extends RoundedJPanel {
	
	private Logic logic;
	private viewCompanyPanel viewCompanyPanel;
	private JLabel companyName;
	
	public viewCompanyGraph(MainFrame app,viewCompanyPanel viewCompanyPanel){		
		setArcw(100);
		setArch(100);
		setColour(Color.WHITE);
		
		logic = new Logic(app);
		this.viewCompanyPanel = viewCompanyPanel;
		
		companyName = new JLabel("");
		companyName.setFont(new Font("San Serif", Font.PLAIN, 35));
		add(companyName);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		double baseline = 350;
		int x = 100;
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		Color revColor = new Color(53,160,184);
		Color profitColor = new Color(219,40,40);
		Color profitMarginColor = new Color(222,201,82);
		if((Company)viewCompanyPanel.getComboBoxModel().getSelectedItem() != null){
			g2.setColor(revColor);
			Rectangle2D.Double revenueYear1 = new Rectangle2D.Double(x,baseline - logic.getRevenue((Company)viewCompanyPanel.getComboBoxModel().getSelectedItem()), 20,logic.getRevenue((Company)viewCompanyPanel.getComboBoxModel().getSelectedItem()));
			Rectangle2D.Double netProfitYear1 = new Rectangle2D.Double(x+30,baseline - logic.getProfit((Company)viewCompanyPanel.getComboBoxModel().getSelectedItem()),20,logic.getProfit((Company)viewCompanyPanel.getComboBoxModel().getSelectedItem()));
			Rectangle2D.Double profitMarginYear1 = new Rectangle2D.Double(x+60,baseline - logic.getProfitMargin((Company)viewCompanyPanel.getComboBoxModel().getSelectedItem()),20,logic.getProfitMargin((Company)viewCompanyPanel.getComboBoxModel().getSelectedItem()));
			Rectangle2D.Double revenueYear2 = new Rectangle2D.Double(x+120,baseline - logic.getRevenue((Company)viewCompanyPanel.getComboBoxModel().getSelectedItem()), 20,logic.getRevenue((Company)viewCompanyPanel.getComboBoxModel().getSelectedItem()));
			Rectangle2D.Double netProfitYear2 = new Rectangle2D.Double(x+150,baseline - logic.getProfit((Company)viewCompanyPanel.getComboBoxModel().getSelectedItem()),20,logic.getProfit((Company)viewCompanyPanel.getComboBoxModel().getSelectedItem()));
			Rectangle2D.Double profitMarginYear2 = new Rectangle2D.Double(x+180,baseline - logic.getProfitMargin((Company)viewCompanyPanel.getComboBoxModel().getSelectedItem()),20,logic.getProfitMargin((Company)viewCompanyPanel.getComboBoxModel().getSelectedItem()));
			Rectangle2D.Double revenueYear3 = new Rectangle2D.Double(x+240,baseline - logic.getRevenue((Company)viewCompanyPanel.getComboBoxModel().getSelectedItem()), 20,logic.getRevenue((Company)viewCompanyPanel.getComboBoxModel().getSelectedItem()));
			Rectangle2D.Double netProfitYear3 = new Rectangle2D.Double(x+270,baseline - logic.getProfit((Company)viewCompanyPanel.getComboBoxModel().getSelectedItem()),20,logic.getProfit((Company)viewCompanyPanel.getComboBoxModel().getSelectedItem()));
			Rectangle2D.Double profitMarginYear3 = new Rectangle2D.Double(x+300,baseline - logic.getProfitMargin((Company)viewCompanyPanel.getComboBoxModel().getSelectedItem()),20,logic.getProfitMargin((Company)viewCompanyPanel.getComboBoxModel().getSelectedItem()));
			g2.fill(revenueYear1);
			g2.fill(revenueYear2);
			g2.fill(revenueYear3);
			g2.fillRect(100,400 , 20, 10);			
			g2.setColor(profitColor);
			g2.fill(netProfitYear1);
			g2.fill(netProfitYear2);
			g2.fill(netProfitYear3);
			g2.fillRect(225,400,20,10);
			g2.setColor(profitMarginColor);
			g2.fill(profitMarginYear1);
			g2.fill(profitMarginYear2);
			g2.fill(profitMarginYear3);
			g2.fillRect(350, 400, 20, 10);
			g2.setColor(Color.BLACK);
			g2.drawString("Revenue", 125, 410);
			g2.drawString("Net Profit", 250, 410);
			g2.drawString("Profit Margin", 375, 410);
			g2.drawString("2012",125,370);
			
		}
		
	}
	protected void setCompanyName(String s){
		companyName.setText(s);
	}

}
