package com.epam.training.designpatterns.fastfoodrestaurant.entities;

import java.util.ArrayList;
import java.util.List;

import com.epam.training.designpatterns.fastfoodrestaurant.food.Condiment;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Food;


public class Order {
	
	private Food food;
	private Client client;
	private boolean priority;
	private List<Condiment> condiments;
	
	private Order(Food food, Client client, List<Condiment> condiments, boolean priority) {
		this.food = food;
		this.client = client;
		this.condiments = new ArrayList<>(condiments);
		this.priority = priority;
	}
	
	public Food getFood() {
		return food;
	}
	
	public Client getClient() {
		return client;
	}
	
	public boolean isPriority() {
		return priority;
	}
	
	public List<Condiment> getCondiments() {
		return new ArrayList<>(condiments);
	}
	
	public static class OrderBuilder {
		
		Food food;
		List<Condiment> condiments = new ArrayList<>();
		Client client;
		boolean priority;
		
		public OrderBuilder(Client client, Food food) {
			this.client = client;
			this.food = food;
		}
		
		public OrderBuilder addCondiment(Condiment condiment) {
			condiments.add(condiment);
			return this;
		}
		
		public OrderBuilder setPriority(boolean priority) {
			this.priority = priority;
			return this;
		}
		
		public Order build() {
			return new Order(food, client, condiments, priority);
		}
		
	}
}

