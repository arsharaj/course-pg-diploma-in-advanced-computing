package p1;

//concrete implemetation class
public class NetworkPrinter implements Printer {
	@Override // is used to override/implement the method
	//Can imple class access i/f constants directly ? Yes
	public void print(String message) {
		System.out.println("Sending a mesg to the server "+message+" speed ="+SPEED);
	}
}
