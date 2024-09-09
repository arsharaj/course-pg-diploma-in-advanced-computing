package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import core.Category;
import core.Order;
import core.Pet;
import core.Status;
import core.User;
import exception.OutOfStockException;

public class Utils {

	public static void addPet(Scanner scan, ArrayList<Pet> pets) {
		System.out.println("Enter pet details : (String name, Category category, int price, int stocks)");
//		String name, Category category, int price, int stocks
		Pet pet = new Pet(scan.next(), Category.valueOf(scan.next().toUpperCase()), scan.nextInt(), scan.nextInt());
		pets.add(pet);
	}

	public static void display(ArrayList<Pet> pets) {
		pets.forEach(pet -> System.out.println(pet));
	}
	
	public static void display(HashMap<Integer, Order> orderMap) {
		System.out.println("All Orders");
		orderMap.forEach((id, order) -> System.out.println(order));
	}

	public static void updatePet(Scanner scan, ArrayList<Pet> pets) {
		System.out.println("Enter petid");
		int petId = scan.nextInt();
		System.out.println("Enter the new pet name : ");
		pets.stream().filter(pet -> pet.getPetId() == petId).forEach(pet -> pet.setName(scan.next()));
	}

	public static void orderPet(Scanner scan, HashMap<Integer, Order> orderMap, ArrayList<Pet> pets,User user) throws OutOfStockException {
		System.out.println("Choose pet : ");
		display(pets);
		System.out.println("Enter pet id and quantity : ");
		int petid = scan.nextInt();
		int quantity = scan.nextInt();
		if (pets.contains(new Pet(petid))) {
			Pet pet=pets.stream().filter(pet1 -> pet1.getPetId() == petid).findFirst().orElseThrow();
			if(pet.getStocks()>=quantity)
			{
				Order order=new Order(pet.getPetId(),quantity,Status.PLACED,user);
				orderMap.put(order.getOrderId(),order);
				pet.setStocks(pet.getStocks()-quantity);
				System.out.println("Order Placed with id "+order.getOrderId());
			}
			else
			{
				throw new OutOfStockException(pet.getName()+"Not Available");
			}
		} else {
			System.out.println("Pet is not available.");
		}
	}

	public static void updateOrderStatus(Scanner scan, HashMap<Integer, Order> orderMap) {
		System.out.println("Enter the order id : ");
		display(orderMap);
		int orderId = scan.nextInt();
		Order order;
		if (( order = orderMap.get(orderId)) == null) {
			System.out.println("Order not found");
		} else {
			System.out.println("Enter the order status : (PLACED, IN_PROCESS, COMPLETED)");
			order.setStatus(Status.valueOf(scan.next().toUpperCase()));
			System.out.println("Order status updated.0");
		}
	}

}
