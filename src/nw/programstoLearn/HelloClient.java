package nw.programstoLearn;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class HelloClient {

	public static void main(String[] args) throws IOException {
//		// Scanner to get the input
//		Scanner sc = new Scanner(System.in); 
		// Step 1:Create the socket object for to carry data
		 DatagramSocket ds = new DatagramSocket(); 
		 InetAddress ip = InetAddress.getLocalHost(); 
		 byte buf[] = null; 
		 
		 // string as input
		 String str="Hello";
		// convert the String input into the byte array. 
         buf = str.getBytes(); 
         // Step 2 : Create the datagramPacket for sending the data.
         Long starttime = System.nanoTime();
         DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 1234); 
      // Step 3 : invoke the send call to actually send the data. 
         ds.send(DpSend); 	
         Long endtime = System.nanoTime();         
         System.out.println(endtime - starttime);
         ds.close();
         
	}

}
