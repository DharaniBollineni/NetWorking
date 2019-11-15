package tcp.day.two;

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

public class TCPJokesServer {

	public static ArrayList<String> jokesArray;

	public static void main(String[] args) throws IOException {

		int turns = 100;
		int remoteServerPort = 1234;

		Random randomGenerator = new Random();
		ServerSocket localServerSocket = new ServerSocket(remoteServerPort);
		System.out.println("Waiting for client on port " + localServerSocket.getLocalPort() + "...");
		Socket server = localServerSocket.accept(); // start listening for incoming client requests
		System.out.println("connected to remote client " + server.getRemoteSocketAddress());

		// read file
		readJokes();
		// read input from client
		InputStream input = server.getInputStream();// pointer to stream which can receive data from server
		BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));

		// send Data to client
		OutputStream outToServer = (OutputStream) server.getOutputStream();
		PrintWriter pWriter = new PrintWriter(outToServer, true);

		int i = 0;
		Long starttime = System.nanoTime();
		// loop
		 while (true)
		{
				 String line = reader.readLine();
				 // break the loop
				 if(line.equalsIgnoreCase("bye"))
				 {
					 reader.close();
					 break;
				 }
				 else
				 {
					 int ranNum=(int)(Math.random()*jokesArray.size());
					 String message=jokesArray.get(ranNum);
//				
//					 // recieved string	
//					 System.out.println(line);
//				
					 //send joke message
					 pWriter.println(message);
					 // System.out.println(message);
				 }
				 	
				
		 }
//		String line = reader.readLine();
//		do {
//			int random = (int) (Math.random() * jokesArray.size());
//			String joke = jokesArray.get(random);
//			pWriter.println(joke);
//			// System.out.println(i + " " +line);
//			line = reader.readLine();
//			
//		} while (!line.equals("bye"));
		
		Long endtime = System.nanoTime();
		System.out.println(endtime - starttime);

		outToServer.close();
		pWriter.close();
		input.close();
		reader.close();
		localServerSocket.close();

	}

	public static void readJokes() {

		jokesArray = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(new File("JokeFile.txt"));
			while (scanner.hasNextLine()) {
				String funnyJoke = scanner.nextLine();
				jokesArray.add(funnyJoke);
			}
			scanner.close();
			System.out.println("Joke number: " + jokesArray.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
