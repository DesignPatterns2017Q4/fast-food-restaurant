package com.epam.training.designpatterns.fastfoodrestaurant;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
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
	public void setup() {
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
		Order simpleChips = new Order.OrderBuilder(client, new Chips())
				.setPriority(true)
				.build();
		client.orderFood(simpleChips);
		assertEquals(105, client.getHappiness());
	}
	
	@Test
	public void testFoodWithSingleCondimentEffect() {
		Order ketchupedChips = new Order.OrderBuilder(client, new Chips())
				.addCondiment(new Ketchup())
				.setPriority(true)
				.build();
		client.orderFood(ketchupedChips);
		assertEquals(110, client.getHappiness());
	}
	
	@Test
	public void testFoodWithMultipleCondimentEffect() {
		Order hotdogWithKetchupMustard = new Order.OrderBuilder(client, new Hotdog())
				.addCondiment(new Mustard())
				.addCondiment(new Ketchup())
				.setPriority(true)
				.build();
		client.orderFood(hotdogWithKetchupMustard);
		assertEquals(102, client.getHappiness());
	}
	
	@Test
	public void testMultipleOrders() {
		Order hotdogWithKetchupMustard = new Order.OrderBuilder(client, new Hotdog())
				.addCondiment(new Mustard())
				.addCondiment(new Ketchup())
				.setPriority(true)
				.build();
		
		Order hotdogWithKetchup = new Order.OrderBuilder(client, new Hotdog())
				.addCondiment(new Ketchup())
				.setPriority(true)
				.build();
		
		client.orderFood(hotdogWithKetchupMustard);
		client.orderFood(hotdogWithKetchup);
		assertEquals(106, client.getHappiness());
	}
	
	@Test
	public void testMultipleClients() {
		Client client1 = new Client(waiter);
		Client client2 = new Client(waiter);
		Client client3 = new Client(waiter);
		Client client4 = new Client(waiter);
		
		Order hotdogWithKetchupMustard1 = new Order.OrderBuilder(client1, new Hotdog())
				.addCondiment(new Mustard())
				.addCondiment(new Ketchup())
				.setPriority(true)
				.build();
		
		Order hotdogWithKetchupMustard2 = new Order.OrderBuilder(client2, new Hotdog())
				.addCondiment(new Mustard())
				.addCondiment(new Ketchup())
				.setPriority(true)
				.build();
		
		Order hotdogWithKetchupMustard3 = new Order.OrderBuilder(client3, new Hotdog())
				.addCondiment(new Mustard())
				.addCondiment(new Ketchup())
				.setPriority(true)
				.build();
		
		Order hotdogWithKetchupMustard4 = new Order.OrderBuilder(client4, new Hotdog())
				.addCondiment(new Mustard())
				.addCondiment(new Ketchup())
				.setPriority(true)
				.build();

		client1.orderFood(hotdogWithKetchupMustard1);
		client2.orderFood(hotdogWithKetchupMustard2);
		client3.orderFood(hotdogWithKetchupMustard3);
		client4.orderFood(hotdogWithKetchupMustard4);
		
		assertEquals(102, client1.getHappiness());
		assertEquals(102, client2.getHappiness());
		assertEquals(102, client3.getHappiness());
		assertEquals(102, client4.getHappiness());
	}
	
	@Test
	public void testWithLotsOfOrders() {
		Order simpleHotdog = new Order.OrderBuilder(client, new Hotdog())
				.setPriority(true)
				.build();
		for (int i = 0; i < 10000; ++i) {
			client.orderFood(simpleHotdog);
		}
		assertEquals(20100, client.getHappiness());
	}

}
