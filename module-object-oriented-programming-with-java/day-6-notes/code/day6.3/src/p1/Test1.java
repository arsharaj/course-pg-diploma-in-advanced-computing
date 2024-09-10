package p1;

public class Test1 {

	public static void main(String[] args) {
		ConsolePrinter consolePrinter=new ConsolePrinter();
		consolePrinter.print("some mesg!!!!");
		FilePrinter filePrinter=new FilePrinter();
		filePrinter.print("another mesg");
		//Can non imple. class DIRECTLY access i/f constants ? NO
		//System.out.println(SPEED);//javac err
		System.out.println(Printer.SPEED); //or can use import static
		

	}

}
