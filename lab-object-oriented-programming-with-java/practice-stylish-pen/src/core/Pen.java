package core;

import java.time.LocalDate;

import enums.InkColor;
import enums.Material;

public class Pen {
	static private int idGenerator = 0;
	static public int quantity = 0;
	static public LocalDate quantityUpdateDate = LocalDate.now();

	private int penId;
	private String brand;
	private String color;
	private InkColor inkColor;
	private Material material;
	private LocalDate listingDate;
	private int price;
	private double discount;

	public Pen(String brand, String color, InkColor inkColor, Material material, LocalDate listingDate, int price,
			double discount) {
		this.penId = ++idGenerator;
		this.brand = brand;
		this.color = color;
		this.inkColor = inkColor;
		this.material = material;
		this.listingDate = listingDate;
		this.price = price;
		this.discount = discount;
	}

	public static int getQuantity() {
		return quantity;
	}

	public static LocalDate getQuantityUpdateDate() {
		return quantityUpdateDate;
	}

	public int getPenId() {
		return penId;
	}

	public String getBrand() {
		return brand;
	}

	public String getColor() {
		return color;
	}

	public InkColor getInkColor() {
		return inkColor;
	}

	public Material getMaterial() {
		return material;
	}

	public LocalDate getListingDate() {
		return listingDate;
	}

	public int getPrice() {
		return price;
	}

	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Pen [ Pen Id = " + penId + ", Brand = " + brand + ", Color = " + color + ", Ink Color = " + inkColor
				+ ", Material = " + material + ", Listing Date = " + listingDate + ", Price = " + price + ", Discount = "
				+ discount + " ]";
	}
}
