package threadsday4;

public class TCPJokesClientTest {

	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
			Thread client = new Thread(new TCPJokesClient());
			client.start();
		}
	}
}
