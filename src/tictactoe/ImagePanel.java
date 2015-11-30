package tictactoe;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private Image image;
	private boolean stretched = true;
	private int xCoord;
	private int yCoord;
	
	public ImagePanel() {
		
	}
	
	public ImagePanel(Image image){
		this.image = image;
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if(image != null){
			if(isStretched())
				g.drawImage(image, xCoord, yCoord, getWidth(), getHeight(), this);
			else
				g.drawImage(image, xCoord, yCoord,this);
		}
	}
	
	public Image getimage() {
		return image;
	}
	
	public void setImage(Image image){
		this.image = image;
		repaint();
	}
	
	public boolean isStretched() {
		return stretched;
	}
}
