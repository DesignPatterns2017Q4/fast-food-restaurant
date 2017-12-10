package com.epam.training.designpatterns.fastfoodrestaurant;

import static org.junit.Assert.assertEquals;

import com.epam.training.designpatterns.fastfoodrestaurant.entities.Restaurant;
import org.junit.Before;
import org.junit.Test;

import com.epam.training.designpatterns.fastfoodrestaurant.entities.Client;
import com.epam.training.designpatterns.fastfoodrestaurant.entities.Order;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Chips;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Hotdog;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Ketchup;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Mustard;

import java.io.IOException;

public class IntegrationTest {
	
	Restaurant restaurant;
	Client client;

	@Before
	public void setUp() throws IOException {
		restaurant = new Restaurant("/restaurant.properties");
		client = new Client(restaurant.getWaiter());
	}
	
	@Test
	public void testSimpleFoodEffect() {
		// GIVEN
		Order simpleChips = new Order.OrderBuilder(client, new Chips())
				.withPriority(true)
				.build();
		// WHEN
		client.orderFood(simpleChips);
		// THEN
		assertEquals(105, client.getHappiness());
	}
	
	@Test
	public void testFoodWithSingleCondimentEffect() {
		// GIVEN
		Order ketchupedChips = new Order.OrderBuilder(client, new Chips())
				.withCondiment(Ketchup.class)
				.withPriority(true)
				.build();
		// WHEN
		client.orderFood(ketchupedChips);
		// THEN
		assertEquals(110, client.getHappiness());
	}
	
	@Test
	public void testFoodWithMultipleCondimentEffect() {
		// GIVEN
		Order hotdogWithKetchupMustard = new Order.OrderBuilder(client, new Hotdog())
				.withCondiment(Mustard.class)
				.withCondiment(Ketchup.class)
				.withPriority(true)
				.build();
		// WHEN
		client.orderFood(hotdogWithKetchupMustard);
		// THEN
		assertEquals(102, client.getHappiness());
	}
	
	@Test
	public void testMultipleOrders() {
		// GIVEN
		Order hotdogWithKetchupMustard = new Order.OrderBuilder(client, new Hotdog())
				.withCondiment(Mustard.class)
				.withCondiment(Ketchup.class)
				.withPriority(true)
				.build();
		
		Order hotdogWithKetchup = new Order.OrderBuilder(client, new Hotdog())
				.withCondiment(Ketchup.class)
				.withPriority(true)
				.build();
		
		// WHEN
		client.orderFood(hotdogWithKetchupMustard);
		client.orderFood(hotdogWithKetchup);
		// THEN
		assertEquals(106, client.getHappiness());
	}
	
	@Test
	public void testMultipleClients() {
		// GIVEN
		Client client1 = new Client(restaurant.getWaiter());
		Client client2 = new Client(restaurant.getWaiter());
		Client client3 = new Client(restaurant.getWaiter());
		Client client4 = new Client(restaurant.getWaiter());
		
		Order hotdogWithKetchupMustard1 = new Order.OrderBuilder(client1, new Hotdog())
				.withCondiment(Mustard.class)
				.withCondiment(Ketchup.class)
				.withPriority(true)
				.build();
		
		Order hotdogWithKetchupMustard2 = new Order.OrderBuilder(client2, new Hotdog())
				.withCondiment(Mustard.class)
				.withCondiment(Ketchup.class)
				.withPriority(true)
				.build();
		
		Order hotdogWithKetchupMustard3 = new Order.OrderBuilder(client3, new Hotdog())
				.withCondiment(Mustard.class)
				.withCondiment(Ketchup.class)
				.withPriority(true)
				.build();
		
		Order hotdogWithKetchupMustard4 = new Order.OrderBuilder(client4, new Hotdog())
				.withCondiment(Mustard.class)
				.withCondiment(Ketchup.class)
				.withPriority(true)
				.build();
		
		// WHEN
		client1.orderFood(hotdogWithKetchupMustard1);
		client2.orderFood(hotdogWithKetchupMustard2);
		client3.orderFood(hotdogWithKetchupMustard3);
		client4.orderFood(hotdogWithKetchupMustard4);
		
		// THEN
		assertEquals(102, client1.getHappiness());
		assertEquals(102, client2.getHappiness());
		assertEquals(102, client3.getHappiness());
		assertEquals(102, client4.getHappiness());
	}

	@Test
	public void testWithLotsOfOrders() {
		// GIVEN
		int numberOfOrders = 1000;
		Order simpleHotdog = new Order.OrderBuilder(client, new Hotdog())
				.withPriority(true)
				.build();
		// WHEN
		for (int i = 0; i < numberOfOrders; ++i) {
			client.orderFood(simpleHotdog);
		}
		// THEN
		assertEquals(100 + 2 * numberOfOrders, client.getHappiness());
	}

}
