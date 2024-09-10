package p3;

//Perform ANY arithmetic operation on 2 double values & return the result
@FunctionalInterface
public interface Computable {
//SAM :
	double compute(double d1, double d2);

	default void show() {
		System.out.println("in i/f def method");
	}

	static void print(String mesg) {
		System.out.println("in i/f static method");
	}
}
