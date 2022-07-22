import java.io.*;
import java.time.*;
import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Egg extends JPanel{

	Image eggImage;
	int eggx, eggy, width=49, height=56;

	public Egg(){
		eggImage = new ImageIcon("Pictures/egg.png").getImage();
	}

	public void setLoc(int xpos, int ypos){
		eggx = xpos;
		eggy = ypos;
	}

	public Rectangle getRectangle(){
		Rectangle rect = new Rectangle(eggx, eggy, width, height);
		return rect;
	}

	public void draw(Graphics g){
		g.drawImage(eggImage, eggx, eggy, null);
	}

	public void eggMove(int y){
		eggy = eggy + y;
	}
}