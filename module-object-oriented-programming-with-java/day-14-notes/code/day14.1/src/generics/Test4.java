package generics;

import static utils.GenericUtils.printElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Test4 {

	public static void main(String[] args) {
		Object o="dfgsfh";//upcasting
		// AL<String>
		ArrayList<String> list1 = new ArrayList<>(Arrays.asList("one", "two"));
		printElements(list1);
		System.out.println("------------------");
		HashSet<Integer> hs=new HashSet<>(Arrays.asList(1,20,13,41,17,2,3));
	//	System.out.println(hs);
		printElements(hs);
		/*
		 * why javac err ?
		 * Even though , String IS-A Object , 
		 * Collection<String> IS NOT A Collection<Object>
		 * OR
		 * String is a sub type of Object 
		 * Collection<String> IS NOT a sub type of Collection<Object>
		 *  
		 */
	}

}
