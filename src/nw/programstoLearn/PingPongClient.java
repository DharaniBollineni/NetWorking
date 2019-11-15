package nw.programstoLearn;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PingPongClient {
	public static void main(String[] args) throws IOException {
		
//		Scanner sc = new Scanner(System.in); 
		  
        // Step 1:Create the socket object for 
        // carrying the data. 
		DatagramSocket ds = new DatagramSocket();   
        InetAddress ip = InetAddress.getLocalHost(); 
        byte buf[] = null; 
        DatagramPacket DpReceive = null; 
        byte[] receive = new byte[65535]; 
        int i=1;
      
        Long starttime = System.nanoTime();
  	          
        while (true) 
        { 
        	 // break the loop if user enters "30" 
            if (i>30) {
            	ds.close();
                break; 
            }
        	//send
        	String strInp=""+i;
            buf = strInp.getBytes();   // convert the String input into the byte array. 
            DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 1235);   //Create the datagramPacket for sending the data. 
            ds.send(DpSend); // invoke the send call to actually send the data. 
            
            // receive
            DpReceive = new DatagramPacket(receive, receive.length);        	 
            ds.receive(DpReceive);    // as p   	 
            System.out.println("Client:-" + data(receive)); 
  
           
            i++;
            
	}
        Long endtime = System.nanoTime();
        
        System.out.println(endtime - starttime);
	}
	
	
	// A utility method to convert the byte array 
    // data into a string representation. 
    public static StringBuilder data(byte[] a) 
    { 
        if (a == null) 
            return null; 
        StringBuilder ret = new StringBuilder(); 
        int i = 0; 
        while (a[i] != 0) 
        { 
            ret.append((char) a[i]); 
            i++; 
        } 
        return ret; 
    } 

}
