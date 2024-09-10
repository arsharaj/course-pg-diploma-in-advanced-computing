package threads5;

public class Tester {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread());// Thread [main,5,main]
		// create a runnable task
		MyRunnableTask task = new MyRunnableTask();
		// Thread(Runnable target,String name)
		Thread t1 = new Thread(task, "one");

		// start the same
		t1.start();
	//	Thread.sleep(1000);
		// How many RUNNABLE(except GC) ? main + 3 child threads
		System.out.println("main interrupting t1");
		t1.interrupt();//main ---> interrupt ---> t1
		System.out.println("main waiting for t1 ");
		t1.join();

		System.out.println("main over....");

	}

}
