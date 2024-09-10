package threads3;

public class Tester {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread());// Thread [main,5,main]
		// create a runnable task
		MyRunnableTask task = new MyRunnableTask();
		// Thread(Runnable target,String name)
		Thread t1 = new Thread(task, "one");
		Thread t2 = new Thread(task, "two");
		Thread t3 = new Thread(task, "three");
		// start the same
		t1.start();
		t2.start();
		t3.start();
		// How many RUNNABLE(except GC) ? main + 3 child threads
		// B.L (thrd exec logic) : main
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " exec count " + i);
			Thread.sleep(100);
		}
		System.out.println("main waiting for child thrds to complete exec");
		System.out.println("t1 is alive " + t1.isAlive() + " t2 " + t2.isAlive() + " t3 " + t3.isAlive());//t 
		t1.join();// main : waiting for t1 to complete
		t2.join();// main : waiting for t2 to complete
		t3.join();// main : waiting for t3 to complete
		System.out.println("t1 is alive " + t1.isAlive() + " t2 " + t2.isAlive() + " t3 " + t3.isAlive());//f

		System.out.println("main over....");

	}

}
