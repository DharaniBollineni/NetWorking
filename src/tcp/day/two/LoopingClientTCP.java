package tcp.day.two;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;



public class LoopingClientTCP {

	public static void main(String[] args) throws IOException {
		
		InetAddress ip = InetAddress.getLocalHost(); //local Ip Address
		int remoteServerPort=1234;//serverPort		
		
		//message to server
        String message = "Hello";
        //send data
        //connect to server
      	Socket socket = new Socket(ip, remoteServerPort);
        // get remort socket address
        System.out.println("Connected to remote Server: " + socket.getRemoteSocketAddress());
        
        //pointer to stream which can send data to server
        OutputStream outToServer = (OutputStream) socket.getOutputStream();
        PrintWriter pWriter = new PrintWriter(outToServer, true);
        // run for 100 times
        int i=0;
        Long starttime = System.nanoTime();
        while(i<100) {
	       	String msg=message+i;
	        pWriter.println(msg);        
			System.out.println(msg);			
			i++;
        }
        Long endtime = System.nanoTime();
	    System.out.println(endtime - starttime);
	    
        pWriter.close();		
		outToServer.close();
		socket.close();
      }

}
