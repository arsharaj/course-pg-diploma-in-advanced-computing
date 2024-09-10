package exception_handling;

public class Test1 {

	public static void main(String[] args) {
		try {
			int a = 100;
			int b = 0;
//			System.out.println("res=" + (a / b));
			String[] names = { "one", "two", "three" };
			System.out.println("name : " + names[2]);
//			System.out.println("Parsed int " + Integer.parseInt("zs1234"));
			String s = null;
			System.out.println("char at 0 index : " + s.charAt(0));
			System.out.println("end of try...");
		}
//		catch (ArithmeticException e) {
//			System.out.println(1);
//		} catch (NullPointerException|NumberFormatException e) {
//			System.out.println(2);
//		}
		catch (ArithmeticException | NumberFormatException | NullPointerException e) {
			System.out.println("Numbers could not be divided by 0.");
			System.out.println("Caught number format exception.");
			System.out.println("Null Pointer Exception.");
//			System.out.println("in catch-all");
//			System.out.println("err mesg "+e.getMessage());
//			System.out.println("exc details "+e);//e.toString()
//			System.out.println("For complete debugging info");
			e.printStackTrace();
		}
		System.out.println("main over....");

	}

}
