package threads4;

import java.util.stream.IntStream;

public class AveragerTask implements Runnable {
	private int start;
	private int end;

	public AveragerTask(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " started");
		try {
			double avg = IntStream.rangeClosed(start, end) // IntStream : start ---end
					.average()
					.orElseThrow();
			System.out.println(Thread.currentThread().getName()+" avg="+avg);

		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + " got err " + e);
		}
		System.out.println(Thread.currentThread().getName() + " over");

	}

}
