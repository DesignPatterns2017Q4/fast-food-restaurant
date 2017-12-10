package com.epam.training.designpatterns.fastfoodrestaurant.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.epam.training.designpatterns.fastfoodrestaurant.food.Condiment;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Food;
import com.epam.training.designpatterns.fastfoodrestaurant.strategies.CookingStrategy;
import com.epam.training.designpatterns.fastfoodrestaurant.strategies.DefaultCookingStrategy;


public class Order {
	
	private Client client;
	private Food food;
	private List<Class<? extends Condiment>> condiments;
	private CookingStrategy cookingStyle;
	private boolean priority;
	
	private Order(Food food, Client client, List<Class<? extends Condiment>> condiments, boolean priority,
					CookingStrategy cookingStyle) {
		this.food = food;
		this.client = client;
		this.condiments = Collections.unmodifiableList(condiments);
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
	
	public List<Class<? extends Condiment>> getCondiments() {
		return condiments;
	}
	
	public CookingStrategy getCookingStyle() {
		return cookingStyle;
	}
	
	public static class OrderBuilder {
		
		private Client client;
		private Food food;
		private List<Class<? extends Condiment>> condiments = new ArrayList<>();
		private CookingStrategy cookingStyle = new DefaultCookingStrategy();
		private boolean priority;
		
		public OrderBuilder(Client client, Food food) {
			this.client = client;
			this.food = food;
		}
		
		public OrderBuilder withCondiment(Class<? extends Condiment> condiment) {
			condiments.add(condiment);
			return this;
		}
		
		public OrderBuilder withCookingStyle(CookingStrategy cookingStyle) {
			this.cookingStyle = cookingStyle;
			return this;
		}
		
		public OrderBuilder withPriority(boolean priority) {
			this.priority = priority;
			return this;
		}
		
		public Order build() {
			return new Order(food, client, condiments, priority, cookingStyle);
		}
		
	}
}

