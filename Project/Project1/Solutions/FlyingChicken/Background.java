import java.io.*;
import java.time.*;
import java.lang.*;
import java.util.*;
import java.util.concurrent.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Background extends JPanel{

	Image backgroundImage;
	int xpos, ypos, width, height;

	public Background(){
		backgroundImage = new ImageIcon("Pictures/background.jpg").getImage();
	}

	//The function to set location
	public void setLoc(int x, int y){
		xpos = x;
		ypos = y;
	}

	//The function to move the background
	public void moveBackground(int y){
		ypos = ypos - y;
	}

	//The function to draw background
	public void drawBackground(Graphics g){
		g.drawImage(backgroundImage, xpos, ypos, null);
	}
}