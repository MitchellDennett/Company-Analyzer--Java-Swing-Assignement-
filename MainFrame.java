package companyanalyzer;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;

public class MainFrame extends JFrame {
	
	private SideTab sideTab;
	private AddNewCompanyPanel newCompanyPanel;
	private viewCompanyPanel viewCompanyPanel;
	private viewCompanyGraph viewCompanyGraph;
	private Container contentPane;
	private HomePanel homePanel;
	private EditCompanyPanel editExistingCompany;

	public MainFrame(){
		
		//Set Size of Frame to Max
		Dimension scrn = getToolkit().getScreenSize();
		setSize(1099,600);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		contentPane = getContentPane();
		contentPane.setBackground(new Color(61,61,61));
		
		//Adding the menu bar and menu items
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		getContentPane().setLayout(null);
		
		//Add Side JPanel to Frame
		sideTab = new SideTab(this);
		sideTab.setBounds(0, 0, 1099, 50);
		sideTab.setPreferredSize(new Dimension(scrn.width,50));
		sideTab.setMaximumSize(new Dimension(scrn.width,50));
		sideTab.setMinimumSize(new Dimension(scrn.width,50));
		contentPane.add(sideTab);
		
		//Add viewCompanyPanel to Frame
		viewCompanyPanel = new viewCompanyPanel(this);
		viewCompanyPanel.setBounds(5, 68, 530, 450);
		viewCompanyPanel.setPreferredSize(new Dimension(1080-300,scrn.height));
		contentPane.add(viewCompanyPanel);
		viewCompanyPanel.setVisible(false);
		viewCompanyGraph = new viewCompanyGraph(this,viewCompanyPanel);
		viewCompanyGraph.setBounds(540, 68, 530, 455);
		getContentPane().add(viewCompanyGraph);
		viewCompanyGraph.setVisible(false);	
		
		//Add AddNewCompanyPanel to Frame
		newCompanyPanel = new AddNewCompanyPanel(this);
		newCompanyPanel.setBounds(5, 68, 1080, 450);
		newCompanyPanel.setPreferredSize(new Dimension(1080-300,scrn.height));
		contentPane.add(newCompanyPanel);
		newCompanyPanel.setVisible(false);
		
		//Add Home Panel To Frame
		homePanel = new HomePanel();
		homePanel.setBounds(5, 68, 1080, 450);
		contentPane.add(homePanel);
		
		//Add Edit JPanel to Frame
		editExistingCompany = new EditCompanyPanel(this);
		editExistingCompany.setBounds(5,68,1080,450);
		contentPane.add(editExistingCompany);
		editExistingCompany.setVisible(false);
		
	}
	
	protected viewCompanyPanel getViewCompanyPanel(){
		return viewCompanyPanel;
	}
	
	protected viewCompanyGraph getCompanyGraph(){
		return viewCompanyGraph;
	}
	
	public static void main(String[] args) {		
		MainFrame frame = new MainFrame();
		frame.setVisible(true);		
	}
	
	//TO DO: MOVE TO LOGIC CLASS
	public void manageJFrames(int button){		
		if(button == 1){			
			viewCompanyPanel.setVisible(false);
			viewCompanyGraph.setVisible(false);
			homePanel.setVisible(false);
			editExistingCompany.setVisible(false);
			newCompanyPanel.setVisible(true);
			contentPane.revalidate();			
		}else if(button == 2){
			newCompanyPanel.setVisible(false);	
			viewCompanyPanel.setVisible(false);
			viewCompanyGraph.setVisible(false);
			editExistingCompany.setVisible(false);
			homePanel.setVisible(true);
			contentPane.revalidate();
		}else if(button == 3){
			newCompanyPanel.setVisible(false);
			homePanel.setVisible(false);
			editExistingCompany.setVisible(false);
			viewCompanyPanel.setVisible(true);
			viewCompanyGraph.setVisible(true);			
			contentPane.revalidate();
		}else if(button == 4){
			newCompanyPanel.setVisible(false);
			homePanel.setVisible(false);;
			viewCompanyPanel.setVisible(false);
			viewCompanyGraph.setVisible(false);
			editExistingCompany.setVisible(true);
			contentPane.revalidate();
		}
	}
}