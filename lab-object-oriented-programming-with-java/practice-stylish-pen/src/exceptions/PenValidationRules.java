package exceptions;

import java.time.LocalDate;

import core.Pen;
import enums.InkColor;
import enums.Material;

public class PenValidationRules {
	public static Pen validatePenInput(String brand, String color, String inkColor, String material,
			LocalDate listingDate, int price, double discount) {
		return new Pen(brand, color, InkColor.valueOf(inkColor), Material.valueOf(material), listingDate, price,
				discount);
	}

}
