package nw.programstoLearn;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class JokeServer {

	
	public static void main(String[] args) throws IOException {
		// Step 1 : Create a socket to listen at port 1234 
        DatagramSocket ds = new DatagramSocket(1235); 
        byte[] receive = new byte[65535]; 
        DatagramPacket DpReceive = null; 
        InetAddress ip = InetAddress.getLocalHost(); 
        String strJoke1="strJoke1";
        String strJoke2="strJoke2";
        
        byte buf[] = null; 
        while (true) 
        { 
        	// Receive
            DpReceive = new DatagramPacket(receive, receive.length); 
            ds.receive(DpReceive);   
            System.out.println("Server:-" + data(receive));        
            // ack or send the joke data 
             
            String jokeStrNum= data(receive).toString();
            Integer jokeNumber= Integer.parseInt(jokeStrNum);
            if(jokeNumber>5)
            {
            	System.out.println("jokeNumber"+jokeNumber);
            	buf = strJoke1.getBytes();   // convert the String input into the byte array.
            	DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 4321);   // convert to data packet  
            	ds.send(DpSend); // sends as packet so no need to convert to         
            }
            else
            {
            	System.out.println("jokeNumber<5"+jokeNumber);
            	buf = strJoke2.getBytes();   // convert the String input into the byte array.
            	DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 4321);   // convert to data packet  
            	ds.send(DpSend); // sends as packet so no need to convert to          
            }
            
//            if (data(receive).toString().equals("30")) 
//            { 
//        
//                System.out.println(" Server sent bye.....EXITING"); 
//                ds.close();
//                break; 
//            } 
            System.out.println("Server-sent");
            receive = new byte[65535]; 
        } 
     
        

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
