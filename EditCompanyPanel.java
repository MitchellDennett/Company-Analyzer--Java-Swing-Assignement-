package companyanalyzer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EditCompanyPanel extends RoundedJPanel {
	
	private JTextField companyNameFld;
	private JTextField companyAddress;
	private JComboBox industry;
	private JButton bSave;
	private Logic logic;
	private JTextField profit;
	private JTextField ebit;
	private JTextField averageAssets;
	private JTextField grossProfit;
	private JTextField sharestxt;
	private JLabel lblIndustry;
	private JLabel lblCurrentAssets;
	private JTextField cAssetTxt;
	private JLabel lblCurrentLiabilites;
	private JTextField cLiabTxt;
	private JLabel lblInventory;
	private JTextField inventoryTxtF;
	private JLabel lblShareholdersEquity;
	private JTextField equityTxt;
	private JTextField revenue;
	private JComboBox<Company> selectCompany;
	private MainFrame appp;
	
	public EditCompanyPanel(MainFrame app){
		this.appp = app;
		setArcw(100);
		setArch(100);
		setColour(Color.WHITE);
		setPreferredSize(new Dimension(500, 420));
		setMinimumSize(new Dimension(500,350));
		setMaximumSize(new Dimension(500,350));
		setLayout(null);	
		
		selectCompany = new JComboBox<Company>(app.getViewCompanyPanel().getComboBoxModel());
		selectCompany.setBounds(68,75,150,19);
		add(selectCompany);
		selectCompany.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(68, 125, 70, 15);
		add(lblAddress);
		
		companyAddress = new JTextField();
		companyAddress.setColumns(10);
		companyAddress.setBounds(271, 127, 114, 19);
		add(companyAddress);		
		
		String[] industryList = {"Retail","Construction","Public Service"};
		industry = new JComboBox(industryList);
		industry.setBounds(271,158,114,19);
		add(industry);
		
		bSave = new JButton("Save and Continue");
		bSave.setBounds(882,401,150,25);
		add(bSave);
		
		JLabel lblProfit = new JLabel("Net Profit");
		lblProfit.setBounds(68, 188, 101, 14);
		add(lblProfit);
		
		JLabel lblEbit = new JLabel("EBIT");
		lblEbit.setBounds(68, 221, 46, 14);
		add(lblEbit);
		
		JLabel lblAverageAssets = new JLabel("Average Assets");
		lblAverageAssets.setBounds(68, 252, 101, 14);
		add(lblAverageAssets);
		
		JLabel grossProfitlbl = new JLabel("Gross Profit");
		grossProfitlbl.setBounds(68, 283, 70, 14);
		add(grossProfitlbl);
		
		profit = new JTextField();
		profit.setBounds(271, 185, 114, 20);
		add(profit);
		profit.setColumns(10);
		
		ebit = new JTextField();
		ebit.setBounds(271, 218, 114, 20);
		add(ebit);
		ebit.setColumns(10);
		
		averageAssets = new JTextField();
		averageAssets.setBounds(271, 249, 114, 20);
		add(averageAssets);
		averageAssets.setColumns(10);
		
		grossProfit = new JTextField();
		grossProfit.setBounds(271, 280, 114, 20);
		add(grossProfit);
		grossProfit.setColumns(10);
		
		JLabel shareOutstanding = new JLabel("Shares Outstanding");
		shareOutstanding.setBounds(68, 314, 135, 14);
		add(shareOutstanding);
		
		sharestxt = new JTextField();
		sharestxt.setBounds(271, 311, 114, 20);
		add(sharestxt);
		sharestxt.setColumns(10);
		
		lblIndustry = new JLabel("Industry");
		lblIndustry.setBounds(68, 160, 46, 14);
		add(lblIndustry);
		
		lblCurrentAssets = new JLabel("Current Assets");
		lblCurrentAssets.setBounds(475, 98, 86, 14);
		add(lblCurrentAssets);
		
		cAssetTxt = new JTextField();
		cAssetTxt.setBounds(631, 95, 114, 20);
		add(cAssetTxt);
		cAssetTxt.setColumns(10);
		
		lblCurrentLiabilites = new JLabel("Current Liabilites");
		lblCurrentLiabilites.setBounds(475, 126, 109, 14);
		add(lblCurrentLiabilites);
		
		cLiabTxt = new JTextField();
		cLiabTxt.setBounds(631, 122, 114, 20);
		add(cLiabTxt);
		cLiabTxt.setColumns(10);
		
		lblInventory = new JLabel("Inventory");
		lblInventory.setBounds(475, 160, 86, 14);
		add(lblInventory);
		
		inventoryTxtF = new JTextField();
		inventoryTxtF.setBounds(631, 157, 114, 20);
		add(inventoryTxtF);
		inventoryTxtF.setColumns(10);
		
		lblShareholdersEquity = new JLabel("Shareholders equity");
		lblShareholdersEquity.setBounds(475, 188, 128, 14);
		add(lblShareholdersEquity);
		
		equityTxt = new JTextField();
		equityTxt.setBounds(631, 185, 114, 20);
		add(equityTxt);
		equityTxt.setColumns(10);
		
		JLabel lblRevenue = new JLabel("Revenue");
		lblRevenue.setBounds(475, 221, 109, 14);
		add(lblRevenue);
		
		revenue = new JTextField();
		revenue.setBounds(631, 218, 114, 20);
		add(revenue);
		revenue.setColumns(10);
		
		bSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				logic.editCompany((Company)selectCompany.getSelectedItem(),appp.getViewCompanyPanel(),appp.getCompanyGraph(),companyNameFld.getText(),companyAddress.getText(),(String)industry.getSelectedItem(),profit.getText(),ebit.getText(),
						averageAssets.getText(),grossProfit.getText(),sharestxt.getText(),cAssetTxt.getText(),cLiabTxt.getText(),
							inventoryTxtF.getText(),equityTxt.getText(),revenue.getText());				
			}
		});
		
	}

}
