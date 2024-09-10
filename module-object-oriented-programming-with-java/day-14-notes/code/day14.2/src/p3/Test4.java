package p3;
import static utils.ShopUtils.*;

import java.util.List;
import java.util.Map;

import com.shop.core.Product;
public class Test4 {

	public static void main(String[] args) {
		List<Product> productList = populateProductList();
		//display product list : forEach
		System.out.println("Product list");
		productList.forEach(p -> System.out.println(p));
		//apply discount on all the prducts in the shop
		double discount=10;
		System.out.println("Applying Discoun");
		productList.forEach(p -> p.setPrice(p.getPrice()-discount));
		//get map of products
		
		Map<Integer, Product> productMap = populateProductMap(productList);
		//display product details from the product map
		System.out.println("Product map");
		productMap.forEach((pid,product) -> System.out.println(product));

	}

}
