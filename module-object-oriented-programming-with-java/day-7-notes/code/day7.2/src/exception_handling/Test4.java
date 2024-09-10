package exception_handling;

public class Test4 {
	// throws
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Before sleep");
		Thread.sleep(1000);
		System.out.println("After sleep");
	}
}
