package string_handling;

//String's == vs equals
public class Test3 {

	public static void main(String[] args) {
		String s1 = new String("hello");
		String s2 = new String("hello");
		String s3 = new String("Hello");
		System.out.println(s1 == s2);// f = because s1 and s2 are two different string objects.
		System.out.println(s1 == s3);// f
		System.out.println(s1.equals(s2));// t = because of content equality.
		System.out.println(s1.equals(s3));// f
		System.out.println(s1.equalsIgnoreCase(s3));// t = because of content equality ignoring cases.
	}

}
