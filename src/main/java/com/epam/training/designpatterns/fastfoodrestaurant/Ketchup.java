package com.epam.training.designpatterns.fastfoodrestaurant;

public class Ketchup extends Extra implements ProductModifier {
	
	private final String NAME = "ketchup";

	public void modifyEffectOfProduct(Product product) {
		product.setEffect(product.getEffect() * 2);
	}

	@Override
	public String getName() {
		return NAME;
	}

}
