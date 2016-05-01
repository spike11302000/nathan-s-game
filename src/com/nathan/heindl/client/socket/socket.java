package com.nathan.heindl.client.socket;

public class socket {
	public static String serverHostname = null;
	public static Integer serverPort = null;

	public static void Connect(String ip, int port) {
		serverHostname = new String(ip);
		serverPort = new Integer(port);
		System.out.println("Attemping to connect to host " + serverHostname + " on port "+serverPort+".");
	}
}
