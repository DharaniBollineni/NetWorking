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

public class TCPJokesMultiServer extends Thread{

	public static ArrayList<String> jokesArray;
	Socket s1=null;
	
	public TCPJokesMultiServer(Socket ss)
	{
		s1=ss;
	}
	public void run()
	{
		try
		{
		int turns=100;
		//int remoteServerPort = 1234;		
		Random randomGenerator = new Random();
		
				//read input from client
		        InputStream input= s1.getInputStream();//pointer to stream which can receive data from server
			    BufferedReader reader = new BufferedReader(new InputStreamReader(s1.getInputStream()));
			    		
				//send Data to client
			    OutputStream outToServer = (OutputStream) s1.getOutputStream();
		        PrintWriter pWriter = new PrintWriter(outToServer, true);
				
				int i=0;
				Long starttime = System.nanoTime();
		        // loop
				while (true)
				{
					// read file
					readJokes();
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
//							 // recieved string	
//							 System.out.println(line);
//						
							 //send joke message
							 pWriter.println(message);
							 // System.out.println(message);
						 }
						 	
						
				 }
//		        while (true) 
//		        { 
//		 			 // break the loop 
//		 			 if(i>turns)
//		 			 {
//		 				 reader.close();
//		 				 break;
//		 			 }
//		 			 else
//		 			 {
//		 				int ranNum=(int)(Math.random()*jokesArray.size());
//		 				String message=jokesArray.get(ranNum);
//		 				 
//			 			 // recieve the output 			
//			 			 String line = reader.readLine();
//			 			 System.out.println(line);
//			 			 
//		 				//send hello message
//		 	        	 pWriter.println(message);        
//		 	 			// System.out.println(message);
//		 	 			
//		 				 
//		 			 }
//		 			 i++;       	
//		            
//		        }  
//				String line=reader.readLine();
//				do {
//
//                    int random = (int)(Math.random() * jokesArray.size());
//
//                    String myJoke = jokesArray.get(random);
//
//                   pWriter.println(myJoke);
//
//                    System.out.println(i + " " +line);
//
//                   
//
//                    line = reader.readLine();
//
//                    i++;
//
//                   
//
//      }while( !line.equals("stop") );
		        Long endtime = System.nanoTime();
			    System.out.println(endtime - starttime);
			    outToServer.close();
		        pWriter.close();
		        input.close();
		        reader.close();
		   
		}
		catch(Exception ex) {
		//	System.out.print(ex);
			
		}

		
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
	
	public static void main(String[] args) throws IOException {
		

		
	}

}
