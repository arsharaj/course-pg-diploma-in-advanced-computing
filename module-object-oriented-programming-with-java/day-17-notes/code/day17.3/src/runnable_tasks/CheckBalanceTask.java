package runnable_tasks;

import java.util.Random;

import com.banking.JointAccount;

public class CheckBalanceTask implements Runnable {
	private JointAccount account;
	private Random randomNoGenerator;

	public CheckBalanceTask(JointAccount account) {
		super();
		this.account = account;
		randomNoGenerator = new Random();
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " started");
		try {
			while (true) {
				synchronized (account) {
					double curntBal = account.checkBalance();
					if (curntBal != 10000) {
						System.out.println("ERROR!!!!!!!!!!!!!!!!");
						System.exit(-1);
					}
				}
				Thread.sleep(randomNoGenerator.nextInt(500) + 100);// 100 --599
			}
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + " got exc " + e);
		}
		System.out.println(Thread.currentThread().getName() + " over");
	}

}
