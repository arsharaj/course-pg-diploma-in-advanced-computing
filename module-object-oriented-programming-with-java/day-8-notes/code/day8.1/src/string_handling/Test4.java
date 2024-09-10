package string_handling;

// literal vs non literal string
// Or we could say the difference between string literals and string objects.
// When we define a string literal then we are calling internal string pool by default
// via intern() method that help in optimizing the string performance.
// The compiler tries to optimize the string literals while compiler is forced to create
// a new object every time a new string object is defined.
// non literal strings are not optimized by the compiler.

// intern method is used to return the canonical representation of the string.
// for two strings t and s , t.intern() == s.intern() iff t.equals(s) == true.
public class Test4 {

	public static void main(String[] args) {
		String s1 = "hello";
		System.out.println(s1.hashCode());
		String s2 = "hello";
		String s3 = new String("hello");
		String s4 = "Hello";
		System.out.println(s1.equals(s2));// t
		System.out.println(s1.equals(s3));// t : because content equality is checked. string class have overridden the
											// equal method for content equality.
		System.out.println(s1.equals(s4));// f
		System.out.println(s1.equalsIgnoreCase(s4));// t
		System.out.println(s1 == s2);// t
		System.out.println(s1 == s3);// f
		System.out.println(s1 == s4);// f
		System.out.println("Interned String Check : " + (s1 == s3.intern()));
		s1 = s2 = s3 = s4 = null;
		// How many objects are marked for GC : 1
		// Because string literal pool is cleared while class unloading time and literal
		// is conceptually not an object.
		String s5 = "hello"; // s5 --> already existing string in literal pool
		System.out.println(s1 == s2);// t
		System.out.println(s1 == s3);// t
		System.out.println(s1 == s4);// t
		System.out.println(s5.hashCode());
	}

}
