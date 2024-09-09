package src.tester;
import src.core.Box;
public class TestBox {
	public static void main(String[] args) {
		Box firstBox, secondBox, thirdBox;
		firstBox = new Box();
		firstBox.show();
		secondBox = new Box(12, 23, 16.8);
		secondBox.show();
		thirdBox = new Box(2.5);
		thirdBox.show();
        Box newbox=firstBox.createNewBox(3, 5, 1.5);
		newbox.show();
		// fourthBox.show();
	}
}