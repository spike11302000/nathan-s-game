package com.nathan.heindl.client;

import com.nathan.heindl.client.render.Render;

public class GameLoop {
	private static long lastTime = System.nanoTime();
	private static double amountOfTicks = 60.0;
	private static double ns = 1000000000 / amountOfTicks;
	private static double delta = 0;
	private static long timer = System.currentTimeMillis();
	public static int updates = 0;
	public static int frames = 0;
	
	public static void gameLoop() {
		while (Main.isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				//Main.Window.update(Render.Graphic);
				
				updates++;
				delta--;
			}
			Render.render(Main.Window.getGraphics());
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames + " Updates: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	
}