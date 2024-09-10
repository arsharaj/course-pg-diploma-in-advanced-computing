package shapes;

public abstract class BoundedShape {
	private int x;
	private int y;

	public BoundedShape(int x, int y) {
	//	super();
		this.x = x;
		this.y = y;
	}
	//override toString to ret x, y

	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}
	//add abstract method declaration : for area computation
	public abstract double area();
	

}
