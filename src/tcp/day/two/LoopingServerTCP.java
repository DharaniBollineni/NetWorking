package tcp.day.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class LoopingServerTCP {

	static int remoteServerPort=1234;
	public static void main(String[] args) throws IOException {
		ServerSocket localServerSocket = new ServerSocket(remoteServerPort);
		System.out.println("Waiting for client on port " + localServerSocket.getLocalPort() + "...");
		Socket server = localServerSocket.accept(); // start listening for incoming client requests
				
		System.out.println("connected to remote client " + server.getRemoteSocketAddress());
		//receive data
		// Read data from the client
		InputStream input= server.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
		
		Long starttime = System.nanoTime();
		int i=0;
		while(i<100) {			
			String line = reader.readLine();
			System.out.println(line);			
			i++;
		}
		Long endtime = System.nanoTime();
	    System.out.println(endtime - starttime);
		
		//close all ports
		server.close();
		input.close();
		localServerSocket.close();

	}

}
