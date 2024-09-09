package practice;

public class TestStringBuilder {

	public static void main(String[] args) {
		// StringBuilder firstString = new StringBuilder("Hello World");
		// StringBuilder secondString = new StringBuilder("Hello World");
		String firstString = new String("Hello World");
		String secondString = new String("Hello World");

		// StringBuilder firstString = ="Hello World";
		// StringBuilder secondString = "Hello World";
		/*
		 * String class have overloaded the equals method for content equality but the
		 * StringBuilder class have not overloaded the equal method for content equality
		 * hence in second case it gives false.
		 * 
		 * Also StringBuilder class does not support String literals.
		 */
		System.out.println(firstString == secondString);
		System.out.println(firstString.equals(secondString));
	}

}
