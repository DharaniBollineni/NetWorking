package nw.programstoLearn;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class HelloServer {

	public static void main(String[] args) throws IOException {
		 // Step 1 : Create a socket to listen at port 1234 
        DatagramSocket ds = new DatagramSocket(1234); 
        byte[] receive = new byte[65535]; 
        
        Long starttime = System.nanoTime();
  
     // Step 2 : create a DatgramPacket to receive the data. 
        DatagramPacket DpReceive = new DatagramPacket(receive, receive.length); 
      
        // Step 3 : revieve the data in byte buffer. 
        ds.receive(DpReceive); 

        System.out.println("Client:-" + data(receive)); 
       
        Long endtime = System.nanoTime();
        System.out.println(endtime - starttime);
        
        ds.close();
        

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
