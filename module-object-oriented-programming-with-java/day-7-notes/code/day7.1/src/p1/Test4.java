package p1;

public class Test4 {

	public static void main(String[] args) {
		Printer[] printers = { new FilePrinter(), 
				new ConsolePrinter(), new NetworkPrinter() };// 4 objs in heap
		System.out.println(printers.getClass());
		for (Printer p : printers) // p=printers[0],.....
		{
			if (p instanceof FilePrinter) {
				FilePrinter fp = (FilePrinter) p;
				fp.openFile();
				p.print("some mesg !!!!");//run time poly
				fp.closeFile();
			} else if (p instanceof NetworkPrinter) {
				NetworkPrinter np = (NetworkPrinter) p;
				np.establishConnection();
				p.print("mesg to srvr"); //run time poly
				np.closeConnection();
			} else
				p.print("any mesg !!!!");//run time poly.

		}

	}

}
