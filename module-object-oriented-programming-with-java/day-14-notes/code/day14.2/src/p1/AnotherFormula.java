package p1;

public class AnotherFormula implements Formula{

	@Override
	public double calculate(double a) {
		// TODO Auto-generated method stub
		return a*a;
	}
	//Can imple class override def method imple ? YES
	@Override
	public double sqrt(double a, double b) {
		// TODO Auto-generated method stub
		return Math.sqrt(a-b);
	}
	

}
