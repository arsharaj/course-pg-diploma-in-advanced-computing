package p3;

import static utils.ShopUtils.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.shop.core.Category;
import com.shop.core.Product;

public class Test6 {

	public static void main(String[] args) {
		List<Product> productList = populateProductList();
		// display product list : forEach
		System.out.println("Product list");
		productList.forEach(p -> System.out.println(p));
		//sort the products as per manu date n display the same
		Collections.sort(productList, (p1,p2) -> p1.getManufactureDate().compareTo(p2.getManufactureDate()));
		System.out.println("Sorted  list as per date ");
		productList.forEach(p -> System.out.println(p));
	
	}

}
