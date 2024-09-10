package threads4;

import java.util.stream.IntStream;

public class EvenPrinterTask implements Runnable {
	private int start;
	private int end;

	public EvenPrinterTask(int start, int end) {
		super();
		this.start = start;
		this.end = end;
		System.out.println("ctor invoked by "+Thread.currentThread().getName());//main
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " started");
		try {
			IntStream.rangeClosed(start, end) // IntStream : start ---end
					.filter(i -> i % 2 == 0).forEach(i -> {
						System.out.println(Thread.currentThread().getName() + " printed " + i);
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + " got err " + e);
		}
		System.out.println(Thread.currentThread().getName() + " over");

	}

}
