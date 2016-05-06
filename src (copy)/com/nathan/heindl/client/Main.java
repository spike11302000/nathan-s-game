package com.nathan.heindl.client;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.nathan.heindl.client.socket.socket;
import com.nathan.heindl.client.utils.Constants;

public class Main extends JFrame implements ActionListener {

	
	public static boolean isRunning = true;
	private static final long serialVersionUID = 1L;
	public static JFrame Window = null;

	public static void Client() {

		System.out.println("Starting client");

		Main w = new Main();
		w.setVisible(true);
		GameLoop.gameLoop();
	}

	private Main() {
		super("Nathan's Game");// name of the game
		Window = this;
		setIconImage(new ImageIcon("res/images/icon.png").getImage());
		setSize(Constants.width, Constants.height);// Size of the game
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		addStartScreen();
		Window.removeAll();
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {// this code is executed when
		String name = e.getActionCommand();     // you click the buttons
		if (name.equals("Start")) {
			String ip = JOptionPane.showInputDialog("Server ip: ");
			String[] IP = ip.split(":");
			socket.Connect(IP[0], Integer.parseInt(IP[1]));
		} else if (name.equals("button2")) {
			System.out.println("button2 has been pressed");
		}

	}
	public void addStartScreen(){
		JButton startButton = new JButton("Start"); // buttons
		JButton button2 = new JButton("button2");
		startButton.addActionListener(this);
		button2.addActionListener(this);
		add(startButton);
		add(button2);
	}
	

	

}
