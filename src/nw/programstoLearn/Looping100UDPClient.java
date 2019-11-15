package nw.programstoLearn;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Looping100UDPClient {

	public static void main(String[] args) throws IOException {
		// Step 1:Create the socket object for to carry data
				 DatagramSocket ds = new DatagramSocket(); 
				 InetAddress ip = InetAddress.getLocalHost(); 
				 byte buf[] = null; 				 
				 // string as input
				 int count=1;
				 String str;
				 Long starttime = System.nanoTime();
				 while(count<=100)
				 {
					 str = "hello"+count;
					// convert the String input into the byte array. 
			         buf = str.getBytes(); 
			         // Step 2 : Create the datagramPacket for sending the data.
			         DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 1234); // check what is 1234
			      // Step 3 : invoke the send call to actually send the data. 
			         ds.send(DpSend);
			         count++;
				 }
				 
				 Long endtime = System.nanoTime();
			     System.out.println(endtime - starttime);
				 	
		         ds.close();

	}

}
