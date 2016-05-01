package com.nathan.heindl.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main extends Thread {
	public static ServerSocket serverSocket = null;
	public static Socket clientSocket = null;

	public Main(Socket accept) {
		clientSocket = accept;
		start();
	}

	public static void Server(int port) {
		System.out.println("Startig server on port:" + port);
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (true) {
			System.out.println("Waiting for Connection");
			try {
				new Main(serverSocket.accept());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void run() {
		System.out.println("New Communication Thread Started");

		try {
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				System.out.println("Server: " + inputLine);
				out.println(inputLine);

				if (inputLine.equals("Bye."))
					break;
			}

			out.close();
			in.close();
			clientSocket.close();
		} catch (IOException e) {
			System.err.println("Problem with Communication Server");
			System.exit(1);
		}
	}

}
