/**
 * 
 */
package threadsday4;


public class MThreadHelloThread extends Thread {
	
	// this is not a shared value, it belongs to each.
	private int threadNumber=-1;
	
	public MThreadHelloThread(int i)
	{
		threadNumber=i;
	}
	
	public void run() // while if you call run() method directly no new Thread is created and code inside run() will execute on current Thread.
	{
		System.out.println("Hello from thread "+threadNumber+" !");
		// System.out.println("Hello from thread "+threadNumber+" !");
	}
	
	public static void main(String[] args) {		
		for(int i = 0; i < 10; i++) {
//			MThreadHelloThread mt=new MThreadHelloThread(i);
//			mt.run();   // direct run
			(new MThreadHelloThread(i)).start();// start() method a new Thread 
			//new Thread is created and code inside run() method is executed in new Thread
		}

	}

}
