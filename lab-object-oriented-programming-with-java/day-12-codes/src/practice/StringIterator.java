package practice;

import java.util.ArrayList;

public class StringIterator {

	public static void main(String[] args) {
		String[] names = { "one", "two", "three", "four", "five" };
		ArrayList<String> strings = new ArrayList<>();
		for (String s : names)
			strings.add(s);
		System.out.println(strings.size());
		for (int j = 0; j < strings.size(); j++) {
			strings.remove(j);
			System.out.println(strings);
		}
		System.out.println(strings); // [two,four]
	}

}
