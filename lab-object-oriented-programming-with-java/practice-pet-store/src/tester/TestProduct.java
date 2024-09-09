package tester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import core.Category;
import core.Order;
import core.Pet;
import core.User;
import exception.AuthenticationException;
import exception.AuthorizationException;
import utils.Utils;

public class TestProduct {
	public static HashMap<Integer, Order> orderMap = new HashMap<>();
	private static List<User> users = List.of(new User("admin", "admin", true), new User("c1", "c1", false),
			new User("c2", "c2", false));
	public static ArrayList<Pet> pets = new ArrayList<>();

	public static void main(String[] args) {
		User user = null;
		try (Scanner scan = new Scanner(System.in)) {
			populate(scan);
			int choice = 0;
			do {
				try {
					System.out.println("--- ");
					System.out.println("0. Exit");
					System.out.println("1. Login");
					System.out.println("2. Add new Pet (Admin)");
					System.out.println("3. Update Pet details (Admin)");
					System.out.println("4. Display all pets");
					System.out.println("5. Order a pet");
					System.out.println("6. Check order status");
					System.out.println("7. Update order status (Admin)");
					System.out.println("8. Display all orders (Admin)");
					System.out.println("9. Display my orders (Customer)");
					System.out.println("10. Log Out");
					System.out.println("Enter your choice : ");
					choice = scan.nextInt();
					switch (choice) {
					case 1:
						user = loginUser(scan);
						break;
					case 2:
						if (user == null) {
							System.out.println("First log in !");
							break;
						} else if (user.isAdmin()) {
							Utils.addPet(scan, pets);
							System.out.println("Added new Pet");
						} else {
							throw new AuthorizationException();
						}
						break;
					case 3:
						if (user == null) {
							System.out.println("First log in !");
							break;
						} else if (user.isAdmin()) {
							Utils.updatePet(scan, pets);
							System.out.println("Updated pet details");
						} else {
							throw new AuthorizationException();
						}
						break;
					case 4:
						Utils.display(pets);
						break;
					case 5:
						if (user == null) {
							System.out.println("First log in !");
							break;
						} else if (!user.isAdmin()) {
							Utils.orderPet(scan, orderMap, pets, user);
						} else {
							throw new AuthorizationException();
						}
						break;
					case 6:
						if (user == null) {
							System.out.println("First log in !");
							break;
						} else if (!user.isAdmin()) {
							System.out.println("Enter order id : ");
							int orderId = scan.nextInt();
							final User tempUser = user;
							System.out.println("Status for this order id (" + orderId + ")");
							orderMap.values().stream()
									.filter(o -> (o.getUser().equals(tempUser) && (o.getOrderId() == orderId)))
									.forEach(o -> System.out.println(o.getStatus()));
						} else {
							throw new AuthorizationException();
						}
						break;
					case 7:
						if (user == null) {
							System.out.println("First log in !");
							break;
						} else if (user.isAdmin()) {
							Utils.updateOrderStatus(scan, orderMap);
						} else {
							throw new AuthorizationException();
						}
						break;
					case 8:
						if (user == null) {
							System.out.println("First log in !");
							break;
						} else if (user.isAdmin()) {
							System.out.println("All Orders");
							orderMap.forEach((id, order) -> System.out.println(order));

						} else {
							throw new AuthorizationException();
						}
						break;
					case 9:
						if (user == null) {
							System.out.println("First log in !");
							break;
						} else if (!user.isAdmin()) {
							final User tempUser = user;
							orderMap.values().stream().filter(o -> o.getUser().equals(tempUser))
									.forEach(o -> System.out.println(o));
						} else {
							throw new AuthorizationException();
						}
						break;
					case 10:
						user = null;
						System.out.println("Logged Out");
						break;
					case 0:
						System.out.println("Thank you for using our services.");
					}
				} catch (Exception e) {
					e.printStackTrace();
					scan.nextLine();
				}
			} while (choice != 0);
		}

	}

	public static User loginUser(Scanner scan) throws AuthenticationException, NoSuchElementException {
		System.out.println("Enter loginid and password");
		String loginId = scan.next();
		String password = scan.next();
		User user = users.stream()
				.filter(user1 -> (user1.getLoginId().equals(loginId)) && (user1.getPassword().equals(password)))
				.findAny().orElseThrow();
		if (user != null) {
			System.out.println("Logged In" + user.getLoginId());
			return user;
		} else {
			throw new AuthenticationException();
		}
	}

	public static void populate(Scanner scan) {
		pets.addAll(Arrays.asList(new Pet("Cat", Category.CAT, 2000, 20), new Pet("Dog", Category.DOG, 3000, 10),
				new Pet("Rabbit", Category.RABBIT, 5000, 5), new Pet("FISH", Category.FISH, 100, 200)));
	}

}
