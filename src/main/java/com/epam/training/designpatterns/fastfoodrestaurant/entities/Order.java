package com.epam.training.designpatterns.fastfoodrestaurant.entities;

import java.util.ArrayList;
import java.util.List;

import com.epam.training.designpatterns.fastfoodrestaurant.food.Condiment;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Food;
import com.epam.training.designpatterns.fastfoodrestaurant.strategies.CookingStrategy;
import com.epam.training.designpatterns.fastfoodrestaurant.strategies.DefaultCookingStrategy;


public class Order {
	
	private Client client;
	private Food food;
	private List<Condiment> condiments;
	CookingStrategy cookingStyle;
	private boolean priority;
	
	private Order(Food food, Client client, List<Condiment> condiments, boolean priority,
					CookingStrategy cookingStyle) {
		this.food = food;
		this.client = client;
		this.condiments = new ArrayList<>(condiments);
		this.priority = priority;
		this.cookingStyle = cookingStyle;
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
	
	public CookingStrategy getCookingStyle() {
		return cookingStyle;
	}
	
	public static class OrderBuilder {
		
		Client client;
		Food food;
		List<Condiment> condiments = new ArrayList<>();
		CookingStrategy cookingStyle = new DefaultCookingStrategy();
		boolean priority;
		
		public OrderBuilder(Client client, Food food) {
			this.client = client;
			this.food = food;
		}
		
		public OrderBuilder addCondiment(Condiment condiment) {
			condiments.add(condiment);
			return this;
		}
		
		public OrderBuilder setCookingStyle(CookingStrategy cookingStyle) {
			this.cookingStyle = cookingStyle;
			return this;
		}
		
		public OrderBuilder setPriority(boolean priority) {
			this.priority = priority;
			return this;
		}
		
		public Order build() {
			return new Order(food, client, condiments, priority, cookingStyle);
		}
		
	}
}

