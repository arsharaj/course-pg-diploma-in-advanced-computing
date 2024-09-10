package tester;

import java.util.Map;
import java.util.Scanner;

import com.shop.core.Product;

import runnable_tasks.DateSorterTask;
import runnable_tasks.PriceSorterTask;

import static utils.ShopUtils.*;

public class TestCollectionIOThreads {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// get product map from Shop utils
			Map<Integer, Product> productMap = populateProductMap(populateProductList());
			System.out.println("Enter file name to store products sorted as per date");
			// Create task instance --attach a thrd -- start the thrd
			Thread t1 = new Thread(new DateSorterTask(productMap, sc.nextLine()), "date_sorter");
			System.out.println("Enter file name to store products sorted as per price");
			Thread t2 = new Thread(new PriceSorterTask(productMap, sc.nextLine()), "price_sorter");
			// runnable : 1
			t1.start();
			t2.start();
			// runnable : 3
			System.out.println("main waiting for child thrds ....");
			t1.join();
			t2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main over....");

	}

}
