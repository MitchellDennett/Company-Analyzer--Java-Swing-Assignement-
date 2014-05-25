package companyanalyzer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;

public class RoundedJPanel extends JPanel {
	
	private int arcw;
	private int arch;
	private Color colour;
	protected boolean wantsBorder = true;
	private GradientPaint gradientPaint = null;
	
	
    protected int strokeSize = 1;
    protected Color shadowColor = Color.black;
    protected boolean shady = true;    
    protected boolean highQuality = true;  
    protected Dimension arcs = new Dimension(arcw,arch);    
    protected int shadowGap = 5;   
    protected int shadowOffset = 4;   
    protected int shadowAlpha = 150;

	
	public RoundedJPanel(){
		super();
	}
	
	public void setArcw(int arcw){
		this.arcw = arcw;
	}
	
	public void setArch(int arch){
		this.arch = arch;
	}
	
	public void setColour(Color colour){
		this.colour = colour;
	}
	
	public void setColour(GradientPaint gradientPaint) {
		this.gradientPaint = gradientPaint;
		
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
				
        if (shady) {
        	Color shadowColorA = new Color(shadowColor.getRed(), 
        			shadowColor.getGreen(), shadowColor.getBlue(), shadowAlpha);
            g2.setColor(shadowColorA);
            g2.fillRoundRect(shadowOffset, shadowOffset, getWidth() - strokeSize - shadowOffset, getHeight() - strokeSize - shadowOffset, 
                    				arcw, arch);
            } else {
            shadowGap = 1;
        }
        
        g2.setColor(colour);
        if(gradientPaint != null){
        	g2.setPaint(gradientPaint);
        }
        g2.fillRoundRect(0, 0, getWidth() - shadowGap, 
        getHeight() - shadowGap, arcw, arch);
        g2.setColor(getForeground());
        g2.setStroke(new BasicStroke(strokeSize));
        if(wantsBorder){
        	g2.drawRoundRect(0, 0, getWidth() - shadowGap, 
        			getHeight() - shadowGap, arcw, arch);
        }
        g2.setStroke(new BasicStroke());	
		
			
	}
	

}
