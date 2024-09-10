package generics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Test3 {

	public static void main(String[] args) {
		//API : Collections class
		//public static void shuffle(List<?> list)
		List<Double> doubles=Arrays.asList(1.0,2.1,4.7,5.9,8.0);
		Vector<String> strings=new Vector<>(Arrays.asList("dfgs","gfh","57356"));
		//Can you shuffle above lists n display the same ?
		Collections.shuffle(doubles);
		System.out.println(doubles);
		Collections.shuffle(strings);
		System.out.println(strings);

	}

}
