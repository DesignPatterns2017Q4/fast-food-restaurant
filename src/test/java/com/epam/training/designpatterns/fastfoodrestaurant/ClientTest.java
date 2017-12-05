package com.epam.training.designpatterns.fastfoodrestaurant;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.epam.training.designpatterns.fastfoodrestaurant.entities.Client;
import com.epam.training.designpatterns.fastfoodrestaurant.entities.Order;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Chips;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Hotdog;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Ketchup;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Mustard;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.Chef;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.DeliveryQueue;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.OrderQueue;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.Waiter;

public class ClientTest {
	
	OrderQueue orderQueue;
	DeliveryQueue deliveryQueue;
	Chef chef;
	Waiter waiter;
	Client client;
	
	@Before
	public void setUp() {
		orderQueue = new OrderQueue();
		deliveryQueue = new DeliveryQueue();
		chef = new Chef(orderQueue, deliveryQueue);
		waiter = new Waiter(orderQueue, deliveryQueue);
		client = new Client(waiter);
		
		chef.setCookingSpeed(0);
		waiter.setOrderTakingSpeed(0);
		waiter.setDeliverySpeed(0);
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
				.withCondiment(new Ketchup())
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
				.withCondiment(new Mustard())
				.withCondiment(new Ketchup())
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
				.withCondiment(new Mustard())
				.withCondiment(new Ketchup())
				.withPriority(true)
				.build();
		
		Order hotdogWithKetchup = new Order.OrderBuilder(client, new Hotdog())
				.withCondiment(new Ketchup())
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
		Client client1 = new Client(waiter);
		Client client2 = new Client(waiter);
		Client client3 = new Client(waiter);
		Client client4 = new Client(waiter);
		
		Order hotdogWithKetchupMustard1 = new Order.OrderBuilder(client1, new Hotdog())
				.withCondiment(new Mustard())
				.withCondiment(new Ketchup())
				.withPriority(true)
				.build();
		
		Order hotdogWithKetchupMustard2 = new Order.OrderBuilder(client2, new Hotdog())
				.withCondiment(new Mustard())
				.withCondiment(new Ketchup())
				.withPriority(true)
				.build();
		
		Order hotdogWithKetchupMustard3 = new Order.OrderBuilder(client3, new Hotdog())
				.withCondiment(new Mustard())
				.withCondiment(new Ketchup())
				.withPriority(true)
				.build();
		
		Order hotdogWithKetchupMustard4 = new Order.OrderBuilder(client4, new Hotdog())
				.withCondiment(new Mustard())
				.withCondiment(new Ketchup())
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
	
	@Ignore
	@Test
	public void testWithLotsOfOrders() {
		// GIVEN
		Order simpleHotdog = new Order.OrderBuilder(client, new Hotdog())
				.withPriority(true)
				.build();
		// WHEN
		for (int i = 0; i < 10000; ++i) {
			client.orderFood(simpleHotdog);
		}
		// THEN
		assertEquals(20100, client.getHappiness());
	}

}
