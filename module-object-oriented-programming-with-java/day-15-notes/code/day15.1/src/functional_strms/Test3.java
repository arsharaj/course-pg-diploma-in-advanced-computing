package functional_strms;

import java.util.Arrays;
import java.util.List;

public class Test3 {

	public static void main(String[] args) {
		// Create Stream<Integer> from a fixed size list
		// (un sorted ) of integers , sort n display it.
		List<Integer> list=Arrays.asList(10,1,3,45,11,34,-20,45);
		System.out.println("orig list ");
		list.forEach(i -> System.out.println(i));
		System.out.println("sorted asc list");
		list.stream() //Stream<Integer>
		.sorted() //sorted Stream<Integer> : asc 
		.forEach(i -> System.out.println(i));
		//desc ordered list
		System.out.println("sorted desc  list");
		list.stream()
		.sorted((i1,i2) -> i2.compareTo(i1))
		.forEach(i -> System.out.println(i));
		

	}

}
