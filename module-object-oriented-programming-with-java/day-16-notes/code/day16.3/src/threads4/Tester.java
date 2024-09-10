package threads4;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter a range ");
			int begin = sc.nextInt();
			int end = sc.nextInt();
			// create a task--attach a thrd --start it !
			// Thread(Runnable instance,String name)
			Thread t1 = new Thread(new EvenPrinterTask(begin, end), "even");
			Thread t2 = new Thread(new OddPrinterTask(begin, end), "odd");
			Thread t3 = new Thread(new AveragerTask(begin, end), "avger");
			//main : RUNNABLE
			t1.start();
			t2.start();
			t3.start();
			System.out.println("main waiting for child thrds....");
			t1.join();
			t2.join();
			t3.join();			
		} catch (Exception e) {
			System.out.println("err in  main "+e);
		}
		System.out.println("main over...");

	}

}
