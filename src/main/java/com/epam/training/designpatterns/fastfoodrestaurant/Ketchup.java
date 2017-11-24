package com.epam.training.designpatterns.fastfoodrestaurant;

public class Ketchup extends Extra implements ProductModifier {

	public void modifyEffectOfProduct(Product product) {
		int productEffect = product.getEffect();
		product.setEffect(productEffect * 2);
	}

}
