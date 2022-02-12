/*
 * PacMan inheriting Size
 * by Hitoshi Ogawa on November 15th, 2021
*/

import java.awt.Color;
import java.awt.Graphics;

public class PacMan extends Face{
	
	public PacMan(int size_, int x_, int y_, int angle_) {
		super(size_, x_, y_, angle_);
	}
	
	void make(Graphics g) {
		super.make(g);
	}
	
	void showData() {
		System.out.println("size is " + getSize());
	}
}