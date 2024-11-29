package package1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Cours_rgst_pan extends JPanel{
	Cours_rgst_pan(){
		this.setPreferredSize(new Dimension(800,800));
	}
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.setPaint(new Color(37, 150, 190));
		g2D.drawLine(10, 50, 500, 50);
		g2D.drawLine(10, 50, 10, 500);
		g2D.drawLine(10, 60, 500, 60);
		
	}

}
