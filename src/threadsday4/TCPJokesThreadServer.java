package threadsday4;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TCPJokesThreadServer {

	
	public static void main(String[] args) throws IOException {		
		
		int remoteServerPort = 3300;
		Socket client =null;
		ServerSocket localServerSocket = new ServerSocket(remoteServerPort); // is welcome socket
		System.out.println("Waiting for client on port " + localServerSocket.getLocalPort() + "...");
		
		
		while(true) {
			client = localServerSocket.accept(); // start listening for incoming client requests
			System.out.println("connected to remote client " + client.getRemoteSocketAddress());
			TCPJokesMultiServer s= new TCPJokesMultiServer(client);
			s.start();

		}		
		
		//localServerSocket.close();
		

	}

	
	
	
}


