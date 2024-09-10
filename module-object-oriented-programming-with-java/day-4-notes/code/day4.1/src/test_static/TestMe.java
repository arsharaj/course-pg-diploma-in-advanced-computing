package test_static;

//Can access ALL static members of the System class
//, w/o className.member
import static java.lang.System.*; // We can invoke all the static members using therir name.

public class TestMe {
	private int i;// instance var (non static)
	private static int j;// static data member

	// static initializer block - used to initialize static member
	// Unlike cpp here we have a construct to initialize static as
	// well as non static variables.
	static {
		out.println("in 1st static init block");
		j = 100;
	}
	static {
		out.println("in 2nd static init block");
	}

	// static method
	public static void staticShow() {
		out.println("from static show " + j);
	}

	// non static method
	public void nonStaticShow() {
		out.println("from non static show " + i + " " + j);
	}

	//parameterized ctor
	public TestMe(int i) {
		out.println("in ctor");
		this.i = i;
	}

	// instance init block - not a recommended way to initialize the non static
	// members because it does not support arguments.
	{
		out.println("in non static init block");
	}

	public static void main(String[] args) {
		out.println("in main");
		staticShow();
		// how will u call non static method ?
		TestMe ref = new TestMe(1234);
		ref.nonStaticShow();
		TestMe ref2 = new TestMe(234);
		// ref.staticShow();
		System.out.println("time : " + currentTimeMillis());

	}

}
