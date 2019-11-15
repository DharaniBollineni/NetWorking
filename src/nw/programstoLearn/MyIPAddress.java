package nw.programstoLearn;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyIPAddress {

	public static void main(String[] args) throws IOException {
		// local host name and address 
        InetAddress localhost = InetAddress.getLocalHost(); 
        System.out.println("System IP Address : " + 
                      (localhost.getHostAddress()).trim()); 
        System.out.println("System IP Address : " + 
                (localhost.getLocalHost().getCanonicalHostName())); 
        
        // Create a socket to print the port number
        DatagramSocket tofindPort=new DatagramSocket();
        System.out.println("System port : " +  tofindPort.getLocalPort());
        System.out.println("System port : " +  tofindPort.getPort());
       // System.out.println("System port : " +  tofindPort.getInetAddress());
        
        //System.out.println("System Port Number: "+ localhost.)

	}

}
