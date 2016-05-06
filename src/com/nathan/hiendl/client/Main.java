package com.nathan.hiendl.client;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import com.nathan.heindl.client.utils.Constants;

public class Main extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private Thread thread; // Display thread
	private boolean running = false; // is the game running?
	private JFrame frame; // Main window

	public static void main(String[] args) {
		Main game = new Main();
		game.frame.setResizable(false);
		game.frame.setTitle("nathan game");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display"); // Making thread named display
		thread.start();
	}

	public void run() {
		while (running) { // Main loop
			update();
			render();
		}
	}
	public void update(){
		
	}
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.blue);
		g.fillRect(0, 0,Constants.width, Constants.height);
		g.dispose();
		bs.show();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join(); // idk
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Main() {
		Dimension size = new Dimension(Constants.width, Constants.height); // Making dimension
		setPreferredSize(size);
		frame = new JFrame();
	}
}
