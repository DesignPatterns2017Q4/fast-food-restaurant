package com.epam.training.designpatterns.fastfoodrestaurant;

public class Mustard extends Extra implements ProductModifier {
	
	private final String NAME = "mustard";

	public void modifyEffectOfProduct(Product product) {
		product.setEffect(1);
	}

	@Override
	public String getName() {
		return NAME;
	}

}
