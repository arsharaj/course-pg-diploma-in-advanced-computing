package functional_strms;

import java.util.Arrays;
import java.util.List;

/*
 * 1.Create int[] ---> IntStream & display its contents.
2. Create AL<Integer> , populate it.
Convert it to sequential stream & display elems
2.5 Convert it to parallel stream & display elems
 */
public class Test1 {

	public static void main(String[] args) {
		// Create int[] ---> IntStream & display its contents.
		int[] data = { 12, 3, 4, 5, 6, 1, -10 };
		System.out.println("Printing int stream");
		Arrays.stream(data) // IntStream : prim int strm
				.forEach(i -> System.out.print(i + " "));// terminal op.
		System.out.println();
		List<Integer> list = Arrays.asList(12, 3, 4, 5, 6, 1, -10);
		// Convert it to seq stream & display elems
		System.out.println("Printing Stream<Integer> : seq ");
		list.stream() // Stream<Integer>
				.forEach(i -> System.out.print(i + " "));
		System.out.println();
		System.out.println("Printing Stream<Integer> : parallel ");
		// Convert it to parallel stream & display elems
		list.parallelStream() // Stream<Integer> : parallel access
				.forEach(i -> System.out.print(i + " "));

	}

}
