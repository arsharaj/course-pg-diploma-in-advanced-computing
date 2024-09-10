package p1;

//concrete implemetation class
public class FilePrinter implements Printer {
	// can imple class add additional func ? YES
	// open file before saving mesg
	public void openFile() {
		System.out.println("opening a file");
	}

	@Override // is used to override/implement the method
	public void print(String message) {
		System.out.println("Saving a mesg in a text file " + message);
	}

	// close file after saving mesg
	public void closeFile() {
		System.out.println("closing a file");
	}
}
