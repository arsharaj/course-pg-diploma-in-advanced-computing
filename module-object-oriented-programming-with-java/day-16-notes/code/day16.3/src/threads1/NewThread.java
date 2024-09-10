package threads1;

//extends Thread : IS-A Thread
public class NewThread extends Thread {
	public NewThread(String threadName) {
		super(threadName);// state : NEW
		start();// state : RUNNABLE
	}

	/*
	 * IMPORTANT : Overriding form of the method CAN NOT add any NEW OR BROADER
	 * CHECKED excs Below is eg of adding NEW checked exc
	 */
	@Override
	public void run() /* throws InterruptedException */ {
		System.out.println(getName() + " strted");
		try {
			// B.L (thrd exec logic)
			for (int i = 0; i < 10; i++) {
				System.out.println(getName() + " exec count " + i);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println("err in thread " + getName() + " exc " + e);
		}
		System.out.println(getName() + " over");
	}

}
