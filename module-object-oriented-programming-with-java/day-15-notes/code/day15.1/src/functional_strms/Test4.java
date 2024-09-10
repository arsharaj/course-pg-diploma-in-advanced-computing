package functional_strms;

import static utils.ShopUtils.populateProductList;

import java.util.List;
import java.util.Scanner;

import com.shop.core.Category;
import com.shop.core.Product;

public class Test4 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Product> productList = populateProductList();
			productList.forEach(p -> System.out.println(p));
			System.out.println("-----------------");
			//accept category from user
			System.out.println("Enter category");
			Category category=Category.valueOf(sc.next().toUpperCase());
			//display sorted products as per price from the specified category
			productList.stream() //Stream<Product>
			.filter(p -> p.getProductCategory()==category) //Stream<Product> : filtered
			.sorted((p1,p2) ->((Double) p1.getPrice()).compareTo(p2.getPrice()))
			.forEach(p -> System.out.println(p));
		}

	}

}
