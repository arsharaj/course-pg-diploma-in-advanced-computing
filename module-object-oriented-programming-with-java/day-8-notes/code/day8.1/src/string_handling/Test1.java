package string_handling;

// Immutability of String
// String buffers supports mutable strings.
// String objects are immutable by default and they can be shared.
public class Test1 {

	public static void main(String[] args) {
		String s = new String("hello");

		String newS = s.concat("hi");
		System.out.println(s);// hello
		System.out.println(newS);
		// concat() method does not change the original string.

		s += "12345";// s=s+"12345"
		System.out.println(s);// hello12345
		// + concatenation override the original string.

		System.out.println(s.toUpperCase());// HELLO12345
		System.out.println(s);// hello12345

		System.out.println(s.replace('l', 'p'));// heppo12345
		System.out.println(s);// hello12345

		String s1 = s.replaceFirst("l", "zzz");
		System.out.println(s);// original
		System.out.println(s1);// replaced
		System.out.println("string len " + s1.length());
	}

}
