package nw.programstoLearn;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class OthersClient {

		byte[] buffer;
		DatagramSocket ds;
		//String DharaniAddr = "10.140.98.154";
		String NatiAddr="10.140.72.58";
		InetAddress ip;
		String s;
		DatagramPacket myPacket;
		int port = 3000;

		public OthersClient() throws Exception{
		ds = new DatagramSocket();
		        //ip = InetAddress.getLocalHost();  
		ip = InetAddress.getByName(NatiAddr);  
		       
		        buffer = null;
		        s = "hi Nat are you enjoying coding";		       
		        buffer = s.getBytes();
		        myPacket = new DatagramPacket(buffer, buffer.length, ip, port);
		        ds.send(myPacket);
		}

		public static void main(String[] args) throws Exception {
		new OthersClient();
		}
		

}
