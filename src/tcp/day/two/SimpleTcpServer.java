package tcp.day.two;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleTcpServer {

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
		String line = reader.readLine();
		System.out.println(line);
		
		
		//Send data to the client:
		//send ack to client
		OutputStream output = server.getOutputStream();
		PrintWriter writer = new PrintWriter(output, true);
		writer.println("Thank you");
		
		//close all ports
		input.close();
		writer.close();
		server.close();	
		localServerSocket.close();
		

	}

}
