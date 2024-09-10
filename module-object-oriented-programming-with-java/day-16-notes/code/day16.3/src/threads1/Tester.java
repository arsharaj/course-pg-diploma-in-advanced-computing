package threads1;

public class Tester {

	public static void main(String[] args) throws InterruptedException{
		System.out.println(Thread.currentThread());// Thread [main,5,main]
		// create n start threads n test concurrency
		NewThread t1 = new NewThread("one");
		NewThread t2 = new NewThread("two");
		NewThread t3 = new NewThread("three");
		// How many RUNNABLE(except GC) ? main + 3 child threads
		// B.L (thrd exec logic) : main
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " exec count " + i);
			Thread.sleep(1000);
		}
		System.out.println("main over....");

	}

}
