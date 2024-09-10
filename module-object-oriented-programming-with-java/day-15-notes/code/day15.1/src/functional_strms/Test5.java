package functional_strms;
import static utils.ShopUtils.*;

import java.util.Map;

import com.shop.core.Category;
import com.shop.core.Product;

public class Test5 {

	public static void main(String[] args) {
		Map<Integer, Product> productMap = populateProductMap
				(populateProductList());
		System.out.println("products in the shop");
		productMap.forEach((k,v)-> System.out.println(v));
		Category cat=Category.BREAD;
		// Display sum of product prices of a specific category : map
		//map --> Collection --> stream --> filter --> map ---> sum
		double sum = productMap.values() //Collection<Product>
		.stream() //Stream<Product>
		.filter(p -> p.getProductCategory()==cat) //Stream<Product> : filtered as per cat
		.mapToDouble(p -> p.getPrice()) //DoubleStream
		.sum();
		System.out.println("sum of products under category "+cat+" = "+sum);
		

	}

}
