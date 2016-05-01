package com.nathan.heindl.client;

public class GameLoop {
	private static long lastTime = System.nanoTime();
	private static double amountOfTicks = 60.0;
	private static double ns = 1000000000 / amountOfTicks;
	private static double delta = 0;
	private static long timer = System.currentTimeMillis();
	private static int updates = 0;
	private static int frames = 0;

	public static void gameLoop() {
		while (Main.isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				updates++;
				delta--;
			}

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