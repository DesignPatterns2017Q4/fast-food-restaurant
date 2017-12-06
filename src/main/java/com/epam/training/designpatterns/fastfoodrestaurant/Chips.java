package com.epam.training.designpatterns.fastfoodrestaurant;

public class Chips extends Product implements Consumable {

	private final String NAME = "chips";
	private double effect = 5.0;

	@Override
	public void consumedBy(Client client) {
		double clientHappiness = client.getHappiness();
		client.setHappiness(clientHappiness * ((100 + effect) / 100));
	}

	@Override
	public String getName() {
		return this.NAME;
	}

	@Override
	public double getEffect() {
		return this.effect;
	}

	@Override
	public void setEffect(double effect) {
		this.effect = effect;
	}

}
