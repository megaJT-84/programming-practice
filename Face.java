/*
 * The value of the variable "size" is not changed 
 * even if Pac-Man is drawn outside the window.
 * by Hitosi Ogawa on November 16th, 2021.
 */

import java.awt.Color;
import java.awt.Graphics;

public class Face {
	private int size;
	private int xCenter;
	private int yCenter;
	private int angle;
	
	public Face(int size_, int x_, int y_, int angle_) {
		setSize(size_);
		setXCenter(x_);
		setYCenter(y_);
		setAngle(angle_);
	}
	
	int getSize() {
		return(size);
	}
	
	void setSize(int num) {
		size = num;
	}
	
	int getXCenter() {
		return(xCenter);
	}
	
	void setXCenter(int num) {
		xCenter = num;
	}
	
	int getYCenter() {
		return(yCenter);
	}
	
	void setYCenter(int num) {
		yCenter = num;
	}
	
	int getAngle() {
		return(angle);
	}
	
	void setAngle(int num) {
		if(num > 90) {
			angle = 90;
		} else {
			angle = num;
		}
	}
	
	void make(Graphics g) {
		g.setColor(Color.yellow);
		g.fillArc(xCenter - size / 2, yCenter - size / 2, 
							size, size, angle / 2, 360 - angle); 
	}
	

}
