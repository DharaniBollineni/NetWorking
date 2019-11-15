package nw.programstoLearn;

import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class JokeHelloRandomServer {

	public static ArrayList<String> jokesArray;

	public static void main(String[] args) throws IOException {

		Random randomGenerator = new Random();
		DatagramSocket ds = new DatagramSocket(1235);
		byte[] receive = new byte[65535];
		DatagramPacket DpReceive = null;
		InetAddress ip = InetAddress.getLocalHost();
		readJokes();

		byte buf[] = null;
		while (true) {
			// Receive
			DpReceive = new DatagramPacket(receive, receive.length);
			ds.receive(DpReceive);			
			String receiveStr = new String(DpReceive.getData(),0,DpReceive.getLength());
			System.out.println("receiveStr "+receiveStr);
			//System.out.println("Server:-" + data(receive));
			if (receiveStr.equals("bye")) {
				System.out.println("Client sent bye.....EXITING");
				ds.close();
				break;
			} 
				// int randomInt = randomGenerator.nextInt(50) + 1;
				int ranNum = (int) (Math.random() * jokesArray.size());
				System.out.println(ranNum);
				String strJoke = jokesArray.get(ranNum);
				buf = strJoke.getBytes(); // convert the String input into the byte array.
				DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 4321); // convert to data packet
				ds.send(DpSend); // sends as packet so no need to convert to
				
			
			//receive = new byte[65535];
		}
	}

	public static void readJokes() {

		jokesArray = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(new File("Jokes.txt"));
			while (scanner.hasNextLine()) {
				String funnyJoke = scanner.nextLine();
				jokesArray.add(funnyJoke);
			}
			scanner.close();
			System.out.println("Joke number: " + jokesArray.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
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
