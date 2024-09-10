package tester;
import static utils.ShopUtils.*;
import static utils.IOUtils.storeProductDetails;

import java.util.Map;
import java.util.Scanner;

import com.shop.core.Product;

public class TestSerialization {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)) {
			//get populated map
			Map<Integer, Product> productMap = populateProductMap(populateProductList());
			System.out.println("Enter file name");
			storeProductDetails(productMap, sc.nextLine());
			System.out.println("data stored....");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main over...");

	}

}
