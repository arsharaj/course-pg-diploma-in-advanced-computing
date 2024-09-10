package functional_strms;

import java.util.stream.IntStream;

public class Test2 {

	public static void main(String[] args) {
		// Create stream of ints between 1-100 & display all even elements.
		IntStream intStrm=IntStream.rangeClosed(1, 100) // IntStream : 1---100
				.filter(i -> {
					System.out.println("in filter");
					return i % 2 == 0;
				}); // IntStream : evens in 1-100
				intStrm.forEach(i -> System.out.println(i));
				System.out.println("--------------------------");
		//		intStrm.forEach(i -> System.out.println(i));//IllgealStateExc : stream is alrdy closed !
				

	}

}
