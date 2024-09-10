package p1;

//concrete implemetation class
public class ConsolePrinter implements Printer {
	@Override // is used to override/implement the method
	public void print(String message) {
		System.out.println("Printing a mesg on the console "+message);
	}
}
