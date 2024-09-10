package p1;

public class Test2 {

	public static void main(String[] args) {
		// indirect ref.
		Printer printer;//i/f ref type of a var is mem allocated in stack
	//	System.out.println(printer);//uni inited local var
		//printer=new Printer();
		//Can you assign i/f ref DIRECTLY to ANY imple class instaance ? YES
		printer=new ConsolePrinter();//up casting : implements
		printer.print("hello");//JVM : run time poly : invokes on obj of ConsolePrinter
		printer=new FilePrinter();//up casting 
		printer.print("hi");//JVM : run time poly : invokes on obj of FilePrinter
		printer=new NetworkPrinter();
		printer.print("sending request....");
	}

}
