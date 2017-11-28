package com.epam.training.designpatterns.fastfoodrestaurant;

public class Chips extends Product implements Consumable {

	private final String NAME = "chips";
	private int effect = 5;

	@Override
	public void consumedBy(Client client) {
		int clientHappiness = client.getHappiness();
		client.setHappiness(clientHappiness * (100 + effect / 100));
	}

	@Override
	public String getName() {
		return this.NAME;
	}

	@Override
	public int getEffect() {
		return this.effect;
	}

	@Override
	public void setEffect(int effect) {
		this.effect = effect;
	}

}
