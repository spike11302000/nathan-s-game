package com.nathan.heindl;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
public class Main extends JFrame implements ActionListener{

	private int width = 1080;
	private int height = 720;
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new Main().setVisible(true);
		}
	
	private Main() {
		super("Nathan's Game");//name of the game
		setSize(width, height);//Size of the game
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JButton button = new JButton("Start"); //buttons
		JButton button2 = new JButton("button2");
		button.addActionListener(this);
		button2.addActionListener(this);
		
		add(button);
		add(button2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {// this code is executed when you click the buttons
		String name = e.getActionCommand();
		
		if(name.equals("Start")) {
			System.out.println("Start has been pressed");
			
		} else if (name.equals("button2")) {
			System.out.println("button2 has been pressed");
			
		}
		
		
	}

}
