package companyanalyzer;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel extends RoundedJPanel {
	
	public HomePanel(){
		
		setArcw(100);
		setArch(100);
		setColour(Color.WHITE);
		setLayout(null);
		JLabel logo = new JLabel();
		logo.setBounds(10, 44, 1037, 340);
		logo.setIcon(new ImageIcon("logo.jpg"));
		add(logo);
	}

}
