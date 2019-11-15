package nw.programstoLearn;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class PingPongServer {

	public static void main(String[] args) throws IOException {
		// Step 1 : Create a socket to listen at port 1234 
        DatagramSocket ds = new DatagramSocket(1235); 
        byte[] receive = new byte[65535]; 
        DatagramPacket DpReceive = null; 
        InetAddress ip = InetAddress.getLocalHost(); 
        byte buf[] = null; 
        
        Long starttime = System.nanoTime();
  	  
        while (true) 
        { 
        	// Receive
            DpReceive = new DatagramPacket(receive, receive.length); 
            ds.receive(DpReceive);   
            System.out.println("Server:-" + data(receive));        
            // ack or send the same data 
            //DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 4321);   // convert to data packet           
            ds.send(DpReceive); // sends as packet so no need to convert to         
            if (data(receive).toString().equals("30")) 
            { 
        
                System.out.println(" Server sent bye.....EXITING"); 
                ds.close();
                break; 
            } 
  
            receive = new byte[65535]; 
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
