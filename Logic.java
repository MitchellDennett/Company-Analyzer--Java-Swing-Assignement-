package companyanalyzer;

import java.io.File;
import java.util.Vector;

import javax.swing.JLabel;

public class Logic {
	
	private viewCompanyPanel viewCompanyPanel;
	private MainFrame app;
	
		
	public Logic(Object app){
		this.app = (MainFrame)app;			
	}
	
	public void createCompany(String name, String address,String industry,String profit, String ebit, String averageAssets, String grossProfit, 
									String sharestxt,String cAssetTxt,String cLiabTxt,String inventoryTxtF,String equityTxt,String revenue){		
		
		 //File nameOfCompany = new File(name);
		 //app.getViewCompanyPanel().getComboBoxModel().addElement(name);
		 Company company = new Company(name,industry);
		 company.loadFinancialInfo(Double.parseDouble(profit), Double.parseDouble(ebit),Double.parseDouble(averageAssets), Double.parseDouble(grossProfit),
				 						Double.parseDouble(cAssetTxt), Double.parseDouble(cLiabTxt), Double.parseDouble(sharestxt),Double.parseDouble(inventoryTxtF),
				 								Double.parseDouble(equityTxt),Long.parseLong(revenue));
		 app.getViewCompanyPanel().getComboBoxModel().addElement(company);		 
	}
	
	public void updateRatios(Company company, viewCompanyPanel panel,viewCompanyGraph graph){
		JLabel[] array = panel.getRatioLabels();
		array[0].setText(String.format("%.2f",company.getRoa()));
		array[1].setText(""+company.getName());
		array[2].setText(""+company.getIndustry());
		array[3].setText(String.format("%.2f",company.getCurrentRatio()));
		array[4].setText(String.format("%.2f",company.getRoe()));
		array[5].setText(String.format("%.2f",company.getAcidRatio()));
		graph.setCompanyName(company.getName());
		graph.repaint();		
	}
	
	public void editCompany(Company company,viewCompanyPanel panel, viewCompanyGraph graph,String name, String address,String industry,String profit, String ebit, String averageAssets, String grossProfit, 
									String sharestxt,String cAssetTxt,String cLiabTxt,String inventoryTxtF,String equityTxt,String revenue){
		
		company.loadFinancialInfo(Double.parseDouble(profit), Double.parseDouble(ebit),Double.parseDouble(averageAssets), Double.parseDouble(grossProfit),
					Double.parseDouble(cAssetTxt), Double.parseDouble(cLiabTxt), Double.parseDouble(sharestxt),Double.parseDouble(inventoryTxtF),
							Double.parseDouble(equityTxt),Long.parseLong(revenue));
		updateRatios(company,panel,graph);
	}
	
	public long getRevenue(Company company){
		return company.getRevenue();
	}
	
	public double getProfit(Company company){
		return company.getProfit();
	}
	
	public double getProfitMargin(Company company){
		return company.getProfitMargin();
	}
}