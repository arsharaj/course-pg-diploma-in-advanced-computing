package p3;

public interface ComputableUtils {
//add a static method : higher order (i.e which can accept SAM behavior)
	//for invoking ANY operation on 2 double nos
	static double testCompute(double a,double b,Computable operation)
	{
		return operation.compute(a, b);
	}
}
