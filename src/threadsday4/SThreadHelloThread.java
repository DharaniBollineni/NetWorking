package threadsday4;

public class SThreadHelloThread extends Thread {
	// used for running thread
	public void start() // its not a static method
	{		System.out.println("Hello from single thread");				
	}

	// one main serves one thread
	public static void main(String[] args) {		
		SThreadHelloThread st=new SThreadHelloThread();
		st.start();	
	}	
}
