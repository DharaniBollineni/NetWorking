package nw.programstoLearn;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class jokeHelloClient {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in); 
		  
        // Step 1:Create the socket object for 
        // carrying the data. 
        DatagramSocket ds = new DatagramSocket(4321); 
        DatagramPacket DpReceive = null; 
        byte[] receive = new byte[65535]; 
  
        InetAddress ip = InetAddress.getLocalHost(); 
        byte buf[] = null; 
  
        // loop while user not enters "bye" 
        String inp = null;
            do {     
            	
                inp = sc.nextLine(); 
            // convert the String input into the byte array. 
            buf = inp.getBytes(); 
  
            // Step 2 : Create the datagramPacket for sending 
            // the data. 
            DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 1235); 
  
            // Step 3 : invoke the send call to actually send 
            // the data. 
            ds.send(DpSend); 
            if(inp.equals("bye"))
            {
            	ds.close();
            	break;
            }
            
            // receive
            DpReceive = new DatagramPacket(receive, receive.length);        	 
            ds.receive(DpReceive);    // as p   	 
            System.out.println("Client:-" + data(receive)); 
  
            // break the loop if user enters "bye" 
        	}while(!inp.equals("bye")); 
            
            System.out.println(inp);
            
            
  

	}
	// data into a string representation.
		public static StringBuilder data(byte[] a) {
			if (a == null)
				return null;
			StringBuilder ret = new StringBuilder();
			int i = 0;
			while (a[i] != 0) {
				ret.append((char) a[i]);
				i++;
			}
			return ret;
		}


}
