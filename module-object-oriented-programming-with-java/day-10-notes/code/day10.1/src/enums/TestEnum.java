package enums;

import java.util.Scanner;

public class TestEnum {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// display all available colors to the user
			System.out.println("Available colors : ");
			for (Color c : Color.values())
				System.out.println(c);
			// prompt user to choose one n parse it
			System.out.println("Choose a color");
			Color chosenColor = Color.valueOf(sc.next().toUpperCase());// out of range : IllegalArgExc
			System.out.println("You chose " + chosenColor);
			chosenColor.setAdditionalCost(chosenColor.getAdditionalCost() + 3000);
			System.out.println("Updated clr cost : " + chosenColor.getAdditionalCost());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("code continues....");
	}
}
