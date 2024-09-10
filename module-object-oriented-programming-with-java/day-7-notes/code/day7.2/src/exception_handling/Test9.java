package exception_handling;

public class Test9 {

	public static void main(String[] args) /* throws InterruptedException */ {
		try {
			testMe("12345");
			System.out.println("end of try in main");
		} catch (Exception e) {
			System.out.println("in main's catch-all");
			System.out.println(e);
		} finally {
			System.out.println("in main's finally");
		}
		System.out.println("main over....");

	}

	static void testMe(String s) throws InterruptedException {
		System.out.println("in testMe");
		try {
			System.out.println("Parsed int value " + Integer.parseInt(s));
			Thread.sleep(1234);
			boolean flag = true;
			if (flag)
				System.exit(0);
			System.out.println("end of meth's try");
		} finally {
			System.out.println("in method's finally");
		}
		System.out.println("end of method");

	}

}
