package com.nathan.heindl.client;

import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.nathan.heindl.client.socket.socket;
import com.nathan.heindl.client.utils.Constants;

public class Main extends JFrame implements ActionListener {

	public final static int width = 1080;
	public final static int height = 720;
	public static boolean isRunning = true;
	private static final long serialVersionUID = 1L;

	public static void Client() {

		System.out.println("Starting client");

		Main Window = new Main();
		Window.setVisible(true);
		GameLoop.gameLoop();
	}

	private Main() {
		super("Nathan's Game");// name of the game
		setSize(width, height);// Size of the game
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		JButton startButton = new JButton("Start"); // buttons
		JButton button2 = new JButton("button2");
		startButton.addActionListener(this);
		button2.addActionListener(this);
		setIconImage(new ImageIcon("res/images/icon.png").getImage());
		add(startButton);
		add(button2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {// this code is executed when
												// you click the buttons
		String name = e.getActionCommand();
		if (name.equals("Start")) {
			String ip = JOptionPane.showInputDialog("Server ip: ");
			String[] IP = ip.split(":");
			socket.Connect(IP[0], Integer.parseInt(IP[1]));
		} else if (name.equals("button2")) {
			System.out.println("button2 has been pressed");

		}

	}

}
