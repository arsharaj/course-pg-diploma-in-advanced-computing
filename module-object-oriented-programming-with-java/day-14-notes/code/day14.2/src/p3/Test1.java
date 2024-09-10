package p3;

import static p3.ComputableUtils.testCompute;

public class Test1 {

	public static void main(String[] args) {
		// invoke testCompute to add 2 doubles
		// traditional / conventional / imperative style

		System.out.println(testCompute(12.34, 5, new Adder()));
		// invoke testCompute to multiply 2 doubles
		// traditional / conventional / imperative style

		System.out.println(testCompute(12.34, 5, new Multipler()));
		//modern/functional / declarative appraoch
		System.out.println(testCompute(12.34, 5,( d1,  d2) -> d1+d2));
		//subtraction 
		System.out.println(testCompute(12.34, 5,(a,b) ->a-b));
	}

}
