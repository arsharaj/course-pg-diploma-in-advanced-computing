package core;

public class Pet {
	static int generatePetId = 0;

	int petId;
	String name;
	Category category;
	int price;
	int stocks;

	public Pet(String name, Category category, int price, int stocks) {
		super();
		this.petId = ++generatePetId;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stocks = stocks;
	}

	public void setStocks(int stocks) {
		this.stocks = stocks;
	}

	public Pet(int petId) {
		super();
		this.petId = petId;
	}

	public int getPetId() {
		return petId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		return this.petId == ((Pet)obj).getPetId();
	}

	public Category getCategory() {
		return category;
	}

	public int getPrice() {
		return price;
	}

	public int getStocks() {
		return stocks;
	}

	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", name=" + name + ", category=" + category + ", price=" + price + ", stocks="
				+ stocks + "]";
	}
}
