package p1;

public interface Printer {
//data members : public static final : implicity added by javac
	int SPEED=100;
	//methods : public abstract : implicity added by javac
	void print(String message);	
}
//Printer p=new Printer();//javac err , on RHS