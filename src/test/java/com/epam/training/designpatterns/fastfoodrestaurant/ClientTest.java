package com.epam.training.designpatterns.fastfoodrestaurant;

import org.junit.Assert;
import org.junit.Test;

import java.util.Queue;
import java.util.LinkedList;

public class ClientTest {

	@Test
	public void testCreateNewClient() {

		Queue<Order> orders = new LinkedList<Order>();
        Chef chef = new Chef(orders);
        Waiter waiter = new Waiter(chef, orders);
        
        Client client = new Client(waiter, Menu.FoodType.Hotdog, Menu.ExtraType.Ketchup);
        
		Assert.assertEquals(Client.class, client.getClass());

	}

}
