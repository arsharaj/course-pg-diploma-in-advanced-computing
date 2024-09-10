package char_io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class BufferedFileCopy {

	public static void main(String[] args) {
		System.out.println("Enter src file n dest file names");
		try (// sc
				Scanner sc = new Scanner(System.in);
				// buf file reader : Java App <-----BR <----- FR <---text file
				BufferedReader br = new BufferedReader(
						new FileReader(sc.nextLine()));
				//buf file write Java App ---> PW --> FW --> dest text file
				PrintWriter pw=new PrintWriter(new FileWriter(sc.nextLine()))
				) {
			   //copy files  -only those lines contains : "Stream" : FP
			    br.lines() //Stream<String>
		//	    .filter(s -> s.contains("Stream"))
			    .forEach(line -> pw.println(line));
			    System.out.println("file copy done !");
			} // pw.close --> pw.flush --> pw.close fw.close
		//,br.close , fr.close => file handle being closed , sc.close
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main over....");

	}

}
