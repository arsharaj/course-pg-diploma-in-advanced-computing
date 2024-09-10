package p3;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<>(List.of(1, 2, 4, 5, 34, 12, 1, 2, -10));
		ints.add(0, 99);
		System.out.println("Orig list");
		ints.forEach(i -> System.out.print(i+" "));
		System.out.println();
		// remove even elems n print the list contents again
		//removeIf(Predicate<? super T> filter)
		//SAM : public boolean test(T o)
		ints.removeIf(i -> i % 2 ==0);
		System.out.println("lis after removal");
		ints.forEach(i -> System.out.print(i+" "));
	}

}
