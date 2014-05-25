package companyanalyzer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class RoundButton extends JButton{
	
	private Ellipse2D.Float shape;
	private Rectangle2D.Double criss;
	private Rectangle2D.Double cross;
	private String type;
	private Polygon polygon;
	private Rectangle2D.Double polygonBottom;
	private Rectangle2D.Double door;
	//private int[] xPoints;
	//private int[] yPoints;
	
	public RoundButton(String type){
		super();
		this.type = type;
		setContentAreaFilled(false);
		setFocusable(false);
		setBorder(BorderFactory.createEmptyBorder());
	
	}
	public void init(){
		shape = new Ellipse2D.Float(0,0, getWidth()-1,getHeight()-1);
		criss = new Rectangle2D.Double((getWidth()/2)-getWidth()/17,getHeight()/3.33,getWidth()/10,getHeight()/2.5);
		cross = new Rectangle2D.Double(getHeight()/3.3,(getWidth()/2)-getWidth()/17,getHeight()/2.5,getWidth()/10);
		int[] xPoints = {getWidth()/2,getWidth()/4,getWidth()/3,getWidth()/2,getWidth()-getWidth()/4};
		int[] yPoints = {getHeight()/5,getHeight()/2,getHeight()/2,getHeight()/2,getHeight()/2};
			
		polygon = new Polygon(xPoints, yPoints, 5);
		polygonBottom = new Rectangle2D.Double(getWidth()/2-getWidth()/6,getHeight()/2,getWidth()/2.9,getHeight()/4);
		door = new Rectangle2D.Double(getWidth()/2-getWidth()/14,getHeight()/1.7,getWidth()/6,getHeight()/6);
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		init();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		if(getModel().isArmed()){
			g2.setColor(Color.WHITE);			
		}else{
			g2.setColor(Color.GRAY);
		}
		g2.fill(shape);
		g2.setColor(Color.WHITE);
		if(type.equals("add")){
			g2.fill(criss);
			g2.fill(cross);
		}else if(type.equals("edit")){
			g2.drawString("edit",getWidth()/3-getWidth()/18,getHeight()/2+getHeight()/9);			
		}else if(type.equals("home")){
			g2.fill(polygon);
			g2.fill(polygonBottom);
			g2.setColor(Color.GRAY);
			g2.fill(door);
		}else if(type.equals("view")){
			g2.setColor(Color.WHITE);
			g2.drawString("view", getWidth()/3-getWidth()/18,getHeight()/2+getHeight()/9);
		}
		
		
		
		super.paintComponent(g);
	}
	
	public void paintBorder(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLACK);
		g2.draw(shape);
	}
}