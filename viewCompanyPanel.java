package companyanalyzer;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextField;

public class viewCompanyPanel extends RoundedJPanel {
	
	private JLabel companyName;
	private JLabel companyIndustry;
	private JLabel priceToEarnings;
	private JLabel eps;
	private JLabel returnOnAssets;
	private JLabel returnOnEquity;
	private JLabel currentRatio;
	private JLabel operatingRatio;
	private JLabel returnOnInvestment;
	private JLabel acidTest;
	private JComboBox<Company> selectCompany;
	private JLabel label;
	private JLabel label_1;
	private DefaultComboBoxModel<Company> comboModel;
	private JLabel nameLabel;
	private JLabel industryLabel;
	private JLabel roaLabel;
	private Logic logic;
	private JLabel acidRatiolbl;
	private JLabel roeLabel;
	private JLabel currRatio;
	private MainFrame app;
	//private Vector<Company> companies;
		
	public viewCompanyPanel(MainFrame app){
		this.app = app; 
		setArcw(100);
		setArch(100);
		setColour(Color.WHITE);
		setPreferredSize(new Dimension(500, 420));
		setMinimumSize(new Dimension(500,350));
		setMaximumSize(new Dimension(500,350));
		setLocation(0,75);
		comboModel = new DefaultComboBoxModel<Company>();
		Company temp = new Company("Fletcher", "Construction");
		temp.loadFinancialInfo(100, 1, 1, 1, 1, 1, 1, 1, 1, 200);
		comboModel.addElement(temp);
		
		logic = new Logic(app);
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{57, 178, 0, 93, 0, 0};
		gridBagLayout.rowHeights = new int[]{49, 20, 56, 14, 14, 14, 14, 14, 14, 18, 14, 14, 14, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		selectCompany = new JComboBox<Company>(comboModel);
		GridBagConstraints gbc_selectCompany = new GridBagConstraints();
		gbc_selectCompany.anchor = GridBagConstraints.NORTH;
		gbc_selectCompany.fill = GridBagConstraints.HORIZONTAL;
		gbc_selectCompany.insets = new Insets(0, 0, 5, 5);
		gbc_selectCompany.gridx = 1;
		gbc_selectCompany.gridy = 2;
		add(selectCompany, gbc_selectCompany);
		selectCompany.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				logic.updateRatios((Company)selectCompany.getSelectedItem(),getThis(),getThis().app.getCompanyGraph());
			}
		});
		
		label = new JLabel("2012");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 3;
		add(label, gbc_label);
		
		label_1 = new JLabel("2013");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 4;
		gbc_label_1.gridy = 3;
		add(label_1, gbc_label_1);
		
		companyName = new JLabel("Company Name:");
		GridBagConstraints gbc_companyName = new GridBagConstraints();
		gbc_companyName.anchor = GridBagConstraints.NORTHWEST;
		gbc_companyName.insets = new Insets(0, 0, 5, 5);
		gbc_companyName.gridx = 1;
		gbc_companyName.gridy = 5;
		add(companyName, gbc_companyName);
		
		nameLabel = new JLabel();
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 5;
		add(nameLabel, gbc_lblNewLabel);
		companyIndustry = new JLabel("Industry:");
		GridBagConstraints gbc_companyIndustry = new GridBagConstraints();
		gbc_companyIndustry.anchor = GridBagConstraints.NORTHWEST;
		gbc_companyIndustry.insets = new Insets(0, 0, 5, 5);
		gbc_companyIndustry.gridx = 1;
		gbc_companyIndustry.gridy = 6;
		add(companyIndustry, gbc_companyIndustry);
		
		industryLabel = new JLabel();
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 6;
		add(industryLabel, gbc_lblNewLabel_1);
		priceToEarnings = new JLabel("P/E:");
		GridBagConstraints gbc_priceToEarnings = new GridBagConstraints();
		gbc_priceToEarnings.anchor = GridBagConstraints.NORTHWEST;
		gbc_priceToEarnings.insets = new Insets(0, 0, 5, 5);
		gbc_priceToEarnings.gridx = 1;
		gbc_priceToEarnings.gridy = 7;
		add(priceToEarnings, gbc_priceToEarnings);
		
		eps = new JLabel("EPS:");
		GridBagConstraints gbc_eps = new GridBagConstraints();
		gbc_eps.anchor = GridBagConstraints.NORTHWEST;
		gbc_eps.insets = new Insets(0, 0, 5, 5);
		gbc_eps.gridx = 1;
		gbc_eps.gridy = 8;
		add(eps, gbc_eps);
		
		currentRatio = new JLabel("Current Ratio");
		GridBagConstraints gbc_currentRatio = new GridBagConstraints();
		gbc_currentRatio.anchor = GridBagConstraints.NORTHWEST;
		gbc_currentRatio.insets = new Insets(0, 0, 5, 5);
		gbc_currentRatio.gridx = 1;
		gbc_currentRatio.gridy = 9;
		add(currentRatio, gbc_currentRatio);
		
		currRatio = new JLabel("");
		GridBagConstraints gbc_currRatio = new GridBagConstraints();
		gbc_currRatio.insets = new Insets(0, 0, 5, 5);
		gbc_currRatio.gridx = 2;
		gbc_currRatio.gridy = 9;
		add(currRatio, gbc_currRatio);
		
		returnOnAssets = new JLabel("Return on Assets:");
		GridBagConstraints gbc_returnOnAssets = new GridBagConstraints();
		gbc_returnOnAssets.anchor = GridBagConstraints.NORTHWEST;
		gbc_returnOnAssets.insets = new Insets(0, 0, 5, 5);
		gbc_returnOnAssets.gridx = 1;
		gbc_returnOnAssets.gridy = 10;
		add(returnOnAssets, gbc_returnOnAssets);
		
		roaLabel = new JLabel();
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 10;
		add(roaLabel, gbc_lblNewLabel_2);
		
		acidTest = new JLabel("Acid Test");
		GridBagConstraints gbc_acidTest = new GridBagConstraints();
		gbc_acidTest.anchor = GridBagConstraints.NORTHWEST;
		gbc_acidTest.insets = new Insets(0, 0, 5, 5);
		gbc_acidTest.gridx = 1;
		gbc_acidTest.gridy = 11;
		add(acidTest, gbc_acidTest);
		
		acidRatiolbl = new JLabel("");
		GridBagConstraints gbc_acidRatiolbl = new GridBagConstraints();
		gbc_acidRatiolbl.insets = new Insets(0, 0, 5, 5);
		gbc_acidRatiolbl.gridx = 2;
		gbc_acidRatiolbl.gridy = 11;
		add(acidRatiolbl, gbc_acidRatiolbl);
		
		operatingRatio = new JLabel("Operating Ratio");
		GridBagConstraints gbc_operatingRatio = new GridBagConstraints();
		gbc_operatingRatio.anchor = GridBagConstraints.NORTHWEST;
		gbc_operatingRatio.insets = new Insets(0, 0, 5, 5);
		gbc_operatingRatio.gridx = 1;
		gbc_operatingRatio.gridy = 12;
		add(operatingRatio, gbc_operatingRatio);
		
		returnOnEquity = new JLabel("Return on Equity:");
		GridBagConstraints gbc_returnOnEquity = new GridBagConstraints();
		gbc_returnOnEquity.anchor = GridBagConstraints.NORTHWEST;
		gbc_returnOnEquity.insets = new Insets(0, 0, 5, 5);
		gbc_returnOnEquity.gridx = 1;
		gbc_returnOnEquity.gridy = 13;
		add(returnOnEquity, gbc_returnOnEquity);
		
		roeLabel = new JLabel("");
		GridBagConstraints gbc_roeLabel = new GridBagConstraints();
		gbc_roeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_roeLabel.gridx = 2;
		gbc_roeLabel.gridy = 13;
		add(roeLabel, gbc_roeLabel);
		
		returnOnInvestment = new JLabel("Return on Investments");
		GridBagConstraints gbc_returnOnInvestment = new GridBagConstraints();
		gbc_returnOnInvestment.insets = new Insets(0, 0, 0, 5);
		gbc_returnOnInvestment.anchor = GridBagConstraints.NORTHWEST;
		gbc_returnOnInvestment.gridx = 1;
		gbc_returnOnInvestment.gridy = 14;
		add(returnOnInvestment, gbc_returnOnInvestment);		 		
	}
	
	public DefaultComboBoxModel<Company> getComboBoxModel(){
		return comboModel;
	}
	
	public Vector<Company> getCompanies(){
		return null;
	}
	
	public JLabel[] getRatioLabels(){
		JLabel[] array = {roaLabel,nameLabel,industryLabel,currRatio,roeLabel,acidRatiolbl};
		return array;
	}
	
	private viewCompanyPanel getThis(){
		return this;
	}
	
}