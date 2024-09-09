package ui;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import core.Pen;
import static exceptions.PenValidationRules.*;

public class PenMain {

	private static HashMap<Integer, Pen> penMap = new HashMap<>();

	public static void main(String[] args) {
		int choice = 0;
		try (Scanner scan = new Scanner(System.in)) {
			populateMap(scan);
			do {
				try {
					System.out.println("--- Style With Pen ---");
					System.out.println("1. Add new pen.");
					System.out.println("2. Update pens stock.");
					System.out.println("3. Discount of 20% on all pens not sold in last 3 months.");
					System.out.println("4. Remove pens not sold in 9 months.");
					System.out.println("5. Exit");
					System.out.println("Enter your choice : ");
					choice = scan.nextInt();
					switch (choice) {
					case 1:
						addNewPen(scan);
						break;
					case 2:
						updatePensStock(scan);
						break;
					case 3:
						applyDiscount();
						break;
					case 4:
						removePens();
						break;
					}
					displayPenMap();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} while (choice != 5);
		}
		System.out.println("Thank You for using our services.");
	}

	private static void displayPenMap() {
		System.out.println("All of the pens are : ");
		penMap.values().forEach(pen -> System.out.println(pen));
	}

	private static void addNewPen(Scanner scan) {
		System.out.println("Enter pen details : (brand, color, inkColor, material, listingDate, price, discount) ");
		Pen newPen = validatePenInput(scan.next(), scan.next(), scan.next().toUpperCase(), scan.next().toUpperCase(),
				LocalDate.parse(scan.next()), scan.nextInt(), scan.nextDouble());
		penMap.put(newPen.getPenId(), newPen);
		Pen.quantity++;
		Pen.quantityUpdateDate = LocalDate.now();
		System.out.println("New pen added.");
	}

	private static void updatePensStock(Scanner scan) {
		System.out.println("Enter updated pen stock : (int) ");
		Pen.quantity = scan.nextInt();
		System.out.println("Updated the pens stock.");
	}

	private static void applyDiscount() {
		penMap.forEach((penId, pen) -> {
			Period period = Period.between(pen.getListingDate(), LocalDate.now());
			if (period.getYears() >= 1 || period.getMonths() >= 3) {
				penMap.get(penId).setDiscount(20.0);
			}
		});
		System.out.println("Discount applied.");
	}

	private static void removePens() {
		Iterator<Entry<Integer, Pen>> penMapItr = penMap.entrySet().iterator();
		if (penMapItr.hasNext()) {
			Period period = Period.between(penMapItr.next().getValue().getListingDate(), LocalDate.now());
			if (period.getYears() >= 1 || period.getMonths() >= 9) {
				penMapItr.remove();
			}
		}
		Pen.quantity--;
		Pen.quantityUpdateDate = LocalDate.now();
		System.out.println("Pens older than 9 months removed.");
	}

	private static void populateMap(Scanner scan) {
		Pen newPen = validatePenInput("Reynolds", "Cyan", "Black".toUpperCase(), "Plastic".toUpperCase(),
				LocalDate.parse("2022-01-03"), 10, 0.2);
		penMap.put(newPen.getPenId(), newPen);
		newPen = validatePenInput("Cello", "Megenta", "Green".toUpperCase(), "Metal".toUpperCase(),
				LocalDate.parse("2023-02-04"), 20, 0.5);
		penMap.put(newPen.getPenId(), newPen);
		newPen = validatePenInput("Flair", "Purple", "Blue".toUpperCase(), "Plastic".toUpperCase(),
				LocalDate.parse("2023-07-12"), 25, 5.0);
		penMap.put(newPen.getPenId(), newPen);
		newPen = validatePenInput("Reynolds", "Red", "Red".toUpperCase(), "Metal".toUpperCase(),
				LocalDate.parse("2022-01-03"), 50, 13.0);
		penMap.put(newPen.getPenId(), newPen);
	}
}
