package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

import com.shop.core.Product;

public interface IOUtils {
//add a method to store sorted product details in a text file , using buffer
	static void storeProducts(String fileName,Stream<Product> products) throws IOException{
		//Java App --> PW --> FW --> text file
		try(PrintWriter pw=new PrintWriter(new FileWriter(fileName))) {
			products.forEach(pw::println);//p-> pw.println(p)
		}
	}
}
