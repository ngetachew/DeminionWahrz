package Element;

import Grid.GameGrid;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.IOException;
import java.awt.Color;


public class Tile
{
	private int xPos;
	private int yPos;
	private int length;
	private int width;
	private int x;
	private int y;
	private int terrainType;
	private String imageName;
	private Image image;
	private Element element;
	
	public Tile(int xP, int yP, int l, int w,int tt, String imagename)
	{
		xPos = xP;
		yPos = yP;
		length = l;
		width = w;
		terrainType = tt;
		imageName = imagename;
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imageName));
		} 
		catch(IOException ex) {
			ex.printStackTrace();
		}		
	}
	public void setCoords(int xCoord,int yCoord)
	{
		x = xCoord;
		y = yCoord;
	}
	public int getXCoord() {
		return x;
	}
	public int getYCoord() {
		return y;
	}
	public int getXPos() {
		return xPos;
	}
	public int getYPos() {
		return yPos;
	}
	public void setElement(Element e) {
		element = e;
	}
	public Element getElement() {
		return element;
	}
	public Image getImage(){
		return image;
	}
	public void highlightTiles() {
	    BufferedImage newImg = new BufferedImage(length, width, BufferedImage.TRANSLUCENT);
	    Graphics2D graphics = newImg.createGraphics(); 
	    Color newColor = Color.GREEN;
	    graphics.setXORMode(newColor);
	    graphics.drawImage(image, xPos, yPos,width,length,null);
	    graphics.dispose();
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawRect(xPos,yPos,width,length);
		g2d.drawImage(image,xPos,yPos,width,length,null);
	}
}