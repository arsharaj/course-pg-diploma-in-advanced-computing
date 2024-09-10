package exception_handling;

//un checked exc 
public class Test2 {

	public static void main(String[] args) {
		// no javac err : since javac DOES NOT force the handling of un chked excs
		// Method of Integer : public static int parseInt(String s) throws
		// NumberFormatException
		System.out.println("Parsed int " + Integer.parseInt("1234"));
	}

}
