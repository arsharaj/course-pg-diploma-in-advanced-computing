package shapes;
import static java.lang.Math.PI;

public  class Circle extends BoundedShape {
	private double radius;
	public Circle(int x,int y,double radius)
	{
		super(x,y);
		this.radius=radius;
		
	}
	//override toString : to ret complete details of Circle
	@Override
	public String toString()
	{
		return "Circle "+super.toString()+" radius="+radius;
	}
	@Override
	public double area()
	{
		return PI*radius*radius;
	}
	
	

}
