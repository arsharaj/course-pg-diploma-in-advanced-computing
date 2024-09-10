package tester;

import com.banking.JointAccount;

import runnable_tasks.BalanceUpdater;
import runnable_tasks.CheckBalanceTask;

public class TestJointAccount {

	public static void main(String[] args) throws InterruptedException{
		//create singleton instance of the joint acct
		JointAccount jointAcct=new JointAccount(10000);
		//create thrds by attaching runnable tasks n start them
		//ThreAD(Runnable instance,String name)
		Thread t1 =new Thread(new BalanceUpdater(jointAcct), "c1");
		Thread t2=new Thread(new CheckBalanceTask(jointAcct), "c2");
		t1.start();
		t2.start();//3 runnables
		System.out.println("waiting for child thrds to complete exec");
		t1.join();
		t2.join();
		System.out.println("main over....");

	}

}
