package threadsday4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TCPJokesClient implements Runnable{

	public void communicateWithServer(int remoteServerPort) throws IOException {
		
		//int remoteServerPort=3300;//serverPort	
		int turns=100;
        String message = "Hello";    //message to server   
		InetAddress ip = InetAddress.getLocalHost(); //local Ip Address
		Socket localSocket = new Socket(ip, remoteServerPort); //connect to server //send data
        System.out.println("Connected to remote Server: " + localSocket.getRemoteSocketAddress()); // get remort socket address
        
        //send data to server
        OutputStream outToServer = (OutputStream) localSocket.getOutputStream();
        PrintWriter pWriter = new PrintWriter(outToServer, true);
        
        //read input from server
        InputStream input= localSocket.getInputStream();//pointer to stream which can receive data from server
	    BufferedReader reader = new BufferedReader(new InputStreamReader(localSocket.getInputStream()));
	    
        int i=0;
        //time mesure
        Long starttime = System.nanoTime();
        // loop
        while (true) 
        { 
        	 if(i>turns)
 			 {
        		 pWriter.println("bye");  
        		 System.out.print("hi111");
 				 reader.close();
 				 break;
 			 }
        	 else{
        		 //send hello message
        		 pWriter.println(message);      			 
     			 // recieve the output 			
     			 String line = reader.readLine();
     			 System.out.println(line);     			 
     			 // break the loop      			
     			 i++;       	
        	 }   	
            
        }  
        Long endtime = System.nanoTime();
	    System.out.println(endtime - starttime);
        outToServer.close();
        pWriter.close();
        input.close();
        reader.close();
        localSocket.close(); 
        

	}

	@Override
	public void run() {
		try {
			communicateWithServer(3300);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
