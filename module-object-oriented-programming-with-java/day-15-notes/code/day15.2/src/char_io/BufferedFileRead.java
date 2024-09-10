package char_io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class BufferedFileRead {

	public static void main(String[] args) {
		System.out.println("Enter src file name");
		try (// sc
				Scanner sc = new Scanner(System.in);
				// buf file reader : Java App <-----BR <----- FR <---text file
				BufferedReader br = new BufferedReader(
						new FileReader(sc.nextLine()))) {
			// chain of i/o strms : created !
			String s = null;
			while ((s = br.readLine()) != null)
				System.out.println(s);
			System.out.println("file read over...");
		} //br.close , fr.close => file handle being closed , sc.close
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main over....");

	}

}
