package runnable_tasks;

import java.util.Random;

import com.banking.JointAccount;

public class BalanceUpdater implements Runnable {
	private JointAccount account;
	private Random randomNoGenerator;

	public BalanceUpdater(JointAccount account) {
		super();
		this.account = account;
		randomNoGenerator=new Random();
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " started");
		try {
			while(true)
			{
				//identify the critical session n guard it in a synched block!
				synchronized (account) {
					account.updateBalance(500);
				}
				
				Thread.sleep(randomNoGenerator.nextInt(500)+100);//100 --599				
			}
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + " got exc " + e);
		}
		System.out.println(Thread.currentThread().getName() + " over");
	}

}
