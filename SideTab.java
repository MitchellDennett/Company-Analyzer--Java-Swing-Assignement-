package companyanalyzer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class SideTab extends RoundedJPanel implements ActionListener{	
	
	private RoundButton addNewCompany;
	private RoundButton editExistingCompany;
	private RoundButton viewCompany;
	private MainFrame app;
	private RoundButton bHome;
	private RoundButton round;

	public SideTab(MainFrame app) {
		
		setArch(0);
		setArcw(0);
		//setColour(new GradientPaint(10,20,new Color(255,140,0),35,2, new Color(255,165,0)));
		setColour(new Color(247,142,49));
		shady = false;
		wantsBorder = false;
		this.app = app;
		
		bHome = new RoundButton("home");
		bHome.setBounds(5, 3, 45, 45);
		bHome.addActionListener(this);
		add(bHome);
		
		addNewCompany = new RoundButton("add");
		addNewCompany.setBounds(75, 3, 45,45);
	
		
		addNewCompany.addActionListener(this);
		setLayout(null);
		add(addNewCompany);
		editExistingCompany = new RoundButton("edit");
		editExistingCompany.setBounds(145, 3, 45, 45);
		editExistingCompany.addActionListener(this);
		add(editExistingCompany);
		viewCompany = new RoundButton("view");
		viewCompany.setBounds(215, 3, 45, 45);
		viewCompany.addActionListener(this);
		add(viewCompany);
		
	
		
	}	
	

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == addNewCompany){
			app.manageJFrames(1);
		}else if(e.getSource() == bHome){			
			app.manageJFrames(2);
		}else if(e.getSource() == viewCompany){
			app.manageJFrames(3);
		}else if(e.getSource() == editExistingCompany){
			app.manageJFrames(4);
		}
		
	}

}