package p1;

public class Test3 {

	public static void main(String[] args) {
		Printer[] printers={new FilePrinter()
				,new ConsolePrinter()
				,new NetworkPrinter()};//4 objs in heap
		for(Printer p : printers) //p=printers[0],.....
			p.print("some mesg !!!!");

	}

}
