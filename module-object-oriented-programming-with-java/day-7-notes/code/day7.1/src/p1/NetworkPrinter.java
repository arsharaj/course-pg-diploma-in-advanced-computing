package p1;

//concrete implemetation class
public class NetworkPrinter implements Printer {
	// establish cn with the remote server
	public void establishConnection() {
		System.out.println("clnt establishes cn with rem server");
	}

	@Override // is used to override/implement the method
	// Can imple class access i/f constants directly ? Yes
	public void print(String message) {
		System.out.println("Sending a mesg to the server " + message + " speed =" + SPEED);
	}

	// close cn from the remote server
	public void closeConnection() {
		System.out.println("clnt closes cn with rem server");
	}
}
