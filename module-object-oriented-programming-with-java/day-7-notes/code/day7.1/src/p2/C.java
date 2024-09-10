package p2;

public class C implements A, B {
	@Override
	public double calculate(double a, double b) {
		System.out.println("A's data=" + A.DATA + " B's data " + B.DATA);
		return a * b;
	}

}
