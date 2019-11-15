package tcp.day.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSMTP {

	//Write	a	java	program	to	send	yourself	an	email.	Connect	
//	directly	to	the	mail	server	and	then	use	the	SMTP	mail	
//	protocol	as	shown	in	the	slides.	You	are	welcome	to	hard	
//	code	the	protocol.	The	point	here	is	to	successfully	send	
//	and	email	and	get	the	feel	for	how	an	application	protocol	
//	is	expressed	over	TCP.	
//	The	ECS	mail	server	is: mail.ecs.vuw.ac.nz
//	The	port	is:	25
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		String hostname = "mail.ecs.vuw.ac.nz"; // server
        int port = 25;        
        Socket socket = new Socket(hostname, port);//create server socket
        
        //------------- Input stream-------------------------
        InputStream input = socket.getInputStream(); //Client read data from server
        BufferedReader reader = new BufferedReader(new InputStreamReader(input)); 
        
        //----------------outputStream--------------------------- 
        OutputStream output = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true); 
        
        
        String line = reader.readLine(); // response from the server once connected
        System.out.println("message 1-"+line);
        
        writer.println("HELO " + hostname);// HELO – Identifies the client to the server, fully qualified domain name, only sent once per session
        line = reader.readLine();// sends the response from the server for HELO session
        System.out.println("message 2-"+line);
        
        //MAIL – Initiate a message transfer, fully qualified domain of originator
        writer.println("MAIL FROM:<bollindhar@ecs.vuw.ac.nz>");
        line = reader.readLine();
        System.out.println("message 3-"+line);

        writer.println("RCPT TO:<bollindhar@ecs.vuw.ac.nz>");
        line = reader.readLine();
        System.out.println("message 4-"+line);
        
    
        writer.println("DATA");
        line = reader.readLine();
        System.out.println("message 5-"+line);    
        
        // no response from the server until ends with "."
        writer.println("SUBJECT: Learning SMTP");
       // line = reader.readLine();
       // System.out.println("message 5-"+line);    
        
       
        writer.println("HELLO Dharani How are you");
        writer.println(".");
        line = reader.readLine();
        System.out.println("message 6-"+line);
        
        writer.println("quit");
        line = reader.readLine();
        System.out.println("message 7-"+line);
	}

}
