package tester;

import java.util.Map;
import java.util.Scanner;

import com.shop.core.Product;

import static utils.IOUtils.restoreProductDetails;

public class TestDeSerialization {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter file name , for restoring product details");
			Map<Integer, Product> productDetails = restoreProductDetails(sc.nextLine());
			System.out.println("Restored product details ");
			productDetails.forEach((k, v) -> System.out.println(v));
		}

	}

}
