package p3;

import static utils.ShopUtils.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.shop.core.Category;
import com.shop.core.Product;

public class Test7 {

	public static void main(String[] args) {
		List<Product> productList = populateProductList();
		// display product list : forEach
		System.out.println("Product list");
		productList.forEach(p -> System.out.println(p));
		String s="hello";//literal string
		int data=12345;
		//function literal
		Comparator<Product> prodComp=(p1,p2) -> p1.getManufactureDate().compareTo(p2.getManufactureDate());
		//sort the products as per manu date n display the same
		Collections.sort(productList,prodComp);
		System.out.println("Sorted  list as per date ");
		productList.forEach(p -> System.out.println(p));
	
	}

}
