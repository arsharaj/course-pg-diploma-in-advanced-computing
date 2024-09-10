package threads3;

import static java.lang.Thread.*;

//implements Runnable
public class MyRunnableTask implements Runnable {

	/*
	 * IMPORTANT : Overriding/Implementing  form of the method CAN NOT add any NEW OR BROADER
	 * CHECKED excs Below is eg of adding NEW checked exc
	 */
	@Override
	public void run() /* throws InterruptedException */ {
		System.out.println(currentThread().getName() + " strted");
		try {
			// B.L (thrd exec logic)
			for (int i = 0; i < 10; i++) {
				System.out.println(currentThread().getName() + " exec count " + i);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println("err in thread " + currentThread().getName() + " exc " + e);
		}
		System.out.println(currentThread().getName() + " over");
	}

}
