package com.nathan.heindl.client.render;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import javax.swing.ImageIcon;
import com.nathan.heindl.client.Main;
import com.nathan.heindl.client.utils.Constants;

public class Render{
	public static Image img = new ImageIcon("res/images/icon.png").getImage();
	public static Graphics Graphic = Main.Window.getGraphics();
	static int i = 0;
	public static void render(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Constants.width, Constants.height);
		g.drawImage(img, i, i, null);
		g.dispose();
		
	}
}
