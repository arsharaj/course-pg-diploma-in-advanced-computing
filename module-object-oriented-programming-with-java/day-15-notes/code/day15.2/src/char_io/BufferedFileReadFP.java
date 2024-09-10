package char_io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class BufferedFileReadFP {

	public static void main(String[] args) {
		System.out.println("Enter src file name");
		try (// sc
				Scanner sc = new Scanner(System.in);
				// buf file reader : Java App <-----BR <----- FR <---text file
				BufferedReader br = new BufferedReader(
						new FileReader(sc.nextLine()))) {
			// chain of i/o strms : created !
			//display file contents
//			br.lines() //Stream<String>
//			.forEach(line -> System.out.println(line));
			//display file contents , with line length > 40 , in upper cased manner
			br.lines()
			.filter(line -> line.length()>40) //Stream<String> : filtered
			.map(s -> s.toUpperCase()) //Stream<String> : upper cased
			.forEach(s -> System.out.println(s));
			System.out.println("file read over...");
		} //br.close , fr.close => file handle being closed , sc.close
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main over....");

	}

}
