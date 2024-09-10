package exception_handling;

public class Test3 {

	public static void main(String[] args) {
		System.out.println("Before sleep");
		// why javac err : javac FORCES to handle checked exc
		// try-catch
		try {
			Thread.sleep(1000);
			System.out.println("end of try...");
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.out.println("After sleep");

	}

}
