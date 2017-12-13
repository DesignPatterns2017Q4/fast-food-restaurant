package com.epam.training.designpatterns.fastfoodrestaurant;

import org.junit.Assert;
import org.junit.Test;

import com.epam.training.designpatterns.fastfoodrestaurant.food.ExtraType;
import com.epam.training.designpatterns.fastfoodrestaurant.food.FoodType;

public class ClientTest {

	@Test
	public void testCreateNewClient() {

		OrderQueue orders = new OrderQueue();
        Chef chef = new Chef(orders);
        Waiter waiter = new Waiter(chef, orders);
        
        Client client = new Client(waiter, FoodType.Hotdog, ExtraType.Ketchup);
        
		Assert.assertEquals(Client.class, client.getClass());

	}

}
