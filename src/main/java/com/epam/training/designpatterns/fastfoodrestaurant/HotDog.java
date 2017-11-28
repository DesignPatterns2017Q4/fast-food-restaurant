package com.epam.training.designpatterns.fastfoodrestaurant;

public class HotDog extends Product implements Consumable {
	
	private int effect = 2;
	private final String NAME = "hotdog";

	@Override
	public void consumedBy(Client client) {
		int clientHappiness = client.getHappiness();
		client.setHappiness(clientHappiness + effect);
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public int getEffect() {
		return effect;
	}

	@Override
	public void setEffect(int effect) {
		this.effect = effect;
	}

}
