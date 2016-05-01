package com.nathan.heindl;

public class Main {
	private static boolean isServer = false;
	public static void main(String[] args) {
		if(args.length<2){
			isServer = false;
		}else if(args[0].equals("server")){
			isServer = true;
		}
		if(isServer){
			com.nathan.heindl.server.Main.Server(Integer.parseInt(args[1]));
		}else{
			com.nathan.heindl.client.Main.Client();
		}

	}

}
