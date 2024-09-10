package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.shop.core.Product;

public interface IOUtils {
//add a static method to store product details from a map , in a bin file using ser.
	static void storeProductDetails(Map<Integer, Product> map, String fileName) throws IOException {
		// chain of strms for ser : Java App ---> OOS --> FOS ---> bin file
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			// write map --> file
			out.writeObject(map);// JVM : HM : ser : yes --- key : Integer , value : Product : not ser.
		}
	}

	// add a static method to re store product details in a map , from a bin file
	// using de ser.
	// in case of any errs , ret empty Map to the caller .
	// in case of no errs --ret populated re-constructed map to the caller
	@SuppressWarnings("unchecked")
	// To tell javac to suppress the warnings during the conversion from raw
	// (Object) ---> generic type(Map)
	static Map<Integer, Product> restoreProductDetails(
			String fileName) /* throws IOException,ClassNotFoundException */ {
		// chain of strms for de-ser
		// Java App <--- OIS <---- FIS <---- bin file
		try (ObjectInputStream in = new ObjectInputStream(
				new FileInputStream(fileName))) {
			return (Map<Integer, Product>) in.readObject();//de ser
		} catch (Exception e) {
			e.printStackTrace();
			//=> de ser : failed , ret empty map
			return new HashMap<>();
		}

	}

}
