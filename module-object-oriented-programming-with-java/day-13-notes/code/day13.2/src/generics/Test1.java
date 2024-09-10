package generics;

import java.util.Arrays;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		// create fixed size list of Integer
		List<Integer> intList = Arrays.asList(1, 2, 34, 4, 6, 7, 8, 1, 5);
		System.out.println(intList);
	//	intList.add(100);
	//	intList.remove(0);
		intList.set(0,99);
		System.out.println(intList);
		

	}

}
