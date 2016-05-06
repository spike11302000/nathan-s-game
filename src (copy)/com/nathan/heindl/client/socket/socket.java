package com.nathan.heindl.client.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class socket {
	public static String serverHostname = null;
	public static Integer serverPort = null;
	public static Socket clientSocket = null;
    public static PrintWriter socketOut = null;
    public static BufferedReader socketIn = null;
	public static void Connect(String ip, int port) {
		serverHostname = new String(ip);
		serverPort = new Integer(port);
		System.out.println("Attemping to connect to host " + serverHostname + " on port "+serverPort+".");
		try {
			clientSocket = new Socket(serverHostname, serverPort);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Server Not Found!", "could not connect to server", JOptionPane.PLAIN_MESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Interal Server Error", "could not connect to server", JOptionPane.PLAIN_MESSAGE);
		}
	}
}
