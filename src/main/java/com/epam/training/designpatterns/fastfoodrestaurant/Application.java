package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

	public static void main(String[] args) {
		
		Client client = new Client();
		Robot robot = new Robot();
		Product product = new HotDog();
		Extra extra = new Ketchup();
		List<Extra> listOfExtras = new ArrayList<Extra>();
		listOfExtras.add(extra);
		Map<Product, List<Extra>> orderedItems = new HashMap<Product, List<Extra>>();
		orderedItems.put(product, listOfExtras);
		Order order = new Order(client, orderedItems);
		Server server = new Server(client, robot, order);
		
		client.sendOrderToServer(server);
	}

}