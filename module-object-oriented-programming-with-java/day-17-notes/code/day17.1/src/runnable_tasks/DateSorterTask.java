package runnable_tasks;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;

import com.shop.core.Product;
import static utils.IOUtils.storeProducts;

public class DateSorterTask implements Runnable {
	private Map<Integer, Product> productMap;
	private String fileName;

	public DateSorterTask(Map<Integer, Product> productMap, String fileName) {
		super();
		this.productMap = productMap;
		this.fileName = fileName;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " strted ");
		try {
			// func literal
			Comparator<Product> comp =
(p1, p2) -> p1.getManufactureDate().compareTo(p2.getManufactureDate());
			Stream<Product> stream = productMap.values() // Collection<Product>
					.stream() // Stream<Product>
					.sorted(comp);
			//simply invoke : IOUtils' method to store product details
			storeProducts(fileName, stream);
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + " got err " + e);
		}
		System.out.println(Thread.currentThread().getName() + " over ");

	}
}
