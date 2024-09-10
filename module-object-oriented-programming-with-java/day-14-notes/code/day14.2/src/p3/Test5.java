package p3;

import static utils.ShopUtils.*;

import java.util.List;
import java.util.Map;

import com.shop.core.Category;
import com.shop.core.Product;

public class Test5 {

	public static void main(String[] args) {
		List<Product> productList = populateProductList();
		// display product list : forEach
		System.out.println("Product list");
		productList.forEach(p -> System.out.println(p));
		Category cat=Category.BISCUITS;
		//remove all products from specified category n display the list again
		productList.removeIf(p -> p.getProductCategory()==cat);
		System.out.println("Product list again ");
		productList.forEach(p -> System.out.println(p));
		
	}

}
