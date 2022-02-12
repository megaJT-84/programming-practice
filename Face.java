/*
 * Face which is an upper class of three types of PacMan
 * by Hitoshi Ogawa on October 25th, 2021
 */

import java.awt.Color;
import java.awt.Graphics;

public class Face {
	private int size;
	private int xCenter;
	private int yCenter;
	private int angle;
	
	int width = 500;
	int height = 500;
	int bar = 30;
	
	public Face() {
	}
	
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
		if(xCenter != 0 && xCenter != width) {
			setXCenter(xCenter);
		}
		if(yCenter != 0 && yCenter != height) {
			setYCenter(yCenter);
		}
	}
	
	int getXCenter() {
		return(xCenter);
	}
	
	void setXCenter(int num) {
		xCenter = num;
		if(size != 0) {
			if(num - size/2 < 0) {
				size = num*2;
			}else if(num + size/2 > width) {
				size = (width - num)*2;
			}
		}
		
	}
	
	int getYCenter() {
		return(yCenter);
	}
	
	void setYCenter(int num) {
		yCenter = num;
		if(size != 0) {
			if(num - size/2 < bar) {
				size = (num - bar)*2;
			}else if(num + size/2 > height) {
				size = (height - num)*2;
			}
		}
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
