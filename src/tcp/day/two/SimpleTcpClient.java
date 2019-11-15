package tcp.day.two;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleTcpClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
//		InetAddress ip = InetAddress.getLocalHost(); 
//		Socket client = new Socket(ip, 1234);
//		OutputStream outToServer = client.getOutputStream();
//		DataOutputStream out = new DataOutputStream(outToServer);
//		
//		BufferedOutputStream bufStream = new BufferedOutputStream(socket.getOutputStream());
//		
//		OutputStream output = socket.getOutputStream();
//		byte[] data= {0,2,4};
//		output.write(data);
		
//		 InetAddress remoteServerInetAddr = InetAddress.getByName(remoteServerAddr);
		// type 1
		/*InetAddress ip = InetAddress.getLocalHost(); 
		int remoteServerPort=1234;
        Socket localSocket = new Socket(ip, remoteServerPort);

        //Send data to server
         String message = "This is string sent from TcpSenderClient";

         System.out.println("Connected to remote client: " + localSocket.getRemoteSocketAddress());
         OutputStream outToServer = localSocket.getOutputStream(); //pointer to stream which can send data to server
         DataOutputStream out = new DataOutputStream(outToServer);

         out.writeUTF(message + " :  " + localSocket.getLocalSocketAddress()); //data to send to server
         
         //receive data from server to client
         InputStream inFromServer = localSocket.getInputStream(); //pointer to stream which can receive data from server
         DataInputStream in = new DataInputStream(inFromServer);
         System.out.println("Server sent us reply as: " + in.readUTF()); //data received from server
         localSocket.close();*/
		
		InetAddress ip = InetAddress.getLocalHost(); //local Ip Address
		int remoteServerPort=1234;//serverPort		
		
		//message to server
        String message = "This is string sent from TcpSenderClient";
        //send data
        //connect to server
      		Socket localSocket = new Socket(ip, remoteServerPort);
        // get remort socket address
        System.out.println("Connected to remote client: " + localSocket.getRemoteSocketAddress());
        
        //pointer to stream which can send data to server
        OutputStream outToServer = (OutputStream) localSocket.getOutputStream();
        PrintWriter pWriter = new PrintWriter(outToServer, true);
        pWriter.println(message);
        
        //receive data from server to client       
        //data received from server
        InputStream input= localSocket.getInputStream();//pointer to stream which can receive data from server
        BufferedReader reader = new BufferedReader(new InputStreamReader(localSocket.getInputStream()));
		String line = reader.readLine();
		System.out.println(line);
        
		pWriter.close();
		outToServer.close();
		localSocket.close();
		
		
		

	}

}
