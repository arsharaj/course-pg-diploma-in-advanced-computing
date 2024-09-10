package shapes;

public class Rectangle extends BoundedShape {
	private double width;
	private double height;

	public Rectangle(int x, int y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	// toString
	@Override
	public String toString() {
		return "Rectangle " + super.toString() + " [width=" + width + ", height=" + height;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return width * height;
	}

}
