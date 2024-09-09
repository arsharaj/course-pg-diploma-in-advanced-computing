package src.core;
public class Box {
	private double length;
	private double breadth;
	private double depth;
	public Box(double length, double breadth, double depth) {
		this.length = length;
		this.breadth = breadth;
		this.depth = depth;
	}
	public Box(double side) {
		this(side, side, side);
	}
	public Box() {
		this(-1);
	}
	public void show() {
		System.out.println("Length : " + this.length);
		System.out.println("Breadth : " + this.breadth);
		System.out.println("Depth : " + this.depth);
	}
	public boolean isEqual(Box anotherBox) {
		if (this.length == anotherBox.length && this.breadth == anotherBox.breadth && this.depth == anotherBox.depth)
			return true;
		else
			return false;
	}
	public Box createNewBox(double lengthOffset, double breadthOffset, double depthOffset) {
		Box newBox = new Box(this.length + lengthOffset, this.breadth + breadthOffset, this.depth + depthOffset);
		return newBox;
	}
}