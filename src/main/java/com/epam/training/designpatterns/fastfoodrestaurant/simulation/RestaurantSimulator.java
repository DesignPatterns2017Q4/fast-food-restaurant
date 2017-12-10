package com.epam.training.designpatterns.fastfoodrestaurant.simulation;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.epam.training.designpatterns.fastfoodrestaurant.workstations.Chef;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.DeliveryQueue;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.OrderQueue;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.Waiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestaurantSimulator {

	private static final Logger logger = LoggerFactory.getLogger("RestaurantSimulator");
	private static final Random random = new Random();

	private Properties config;
	private int maxNumberOfClients;
	private int maxClientSpawnTime;

	private OrderQueue orderQueue;
	private DeliveryQueue deliveryQueue;
	private Chef chef;
	private Waiter waiter;


	public static void main(String[] args) throws InterruptedException, IOException {
		RestaurantSimulator restaurant = new RestaurantSimulator();
		restaurant.openConfigFile();
		restaurant.readSimulationValues();
		restaurant.createWorkStations();
		restaurant.startSimulation();
	}

	private void startSimulation() throws InterruptedException {
		logIntroduction();
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < maxNumberOfClients; ++i) {
			executor.submit(new SimulatedClient(waiter));
			Thread.sleep(random.nextInt(maxClientSpawnTime));
		}
	}

	private void createWorkStations() {
		orderQueue = createOrderQueue();
		deliveryQueue = createDeliveryQueue();
		waiter = createWaiter();
		chef = createChef();
	}

	private OrderQueue createOrderQueue() {
		return new OrderQueue();
	}

	private DeliveryQueue createDeliveryQueue() {
		return new DeliveryQueue();
	}

	private Waiter createWaiter() {
		Waiter waiter = new Waiter(orderQueue, deliveryQueue);
		int orderTakingSpeed = Integer.parseInt(config.getProperty("waiter.order_speed"));
		int deliverySpeed = Integer.parseInt(config.getProperty("waiter.delivery_speed"));
		waiter.setOrderTakingSpeed(orderTakingSpeed);
		waiter.setDeliverySpeed(deliverySpeed);
		return waiter;
	}

	private Chef createChef() {
		Chef chef = new Chef(orderQueue, deliveryQueue);
		int cookingSpeed = Integer.parseInt(config.getProperty("chef.cooking_speed"));
		chef.setCookingSpeed(cookingSpeed);
		return chef;
	}

	private void openConfigFile() throws IOException {
		config = new Properties();
		config.load(RestaurantSimulator.class.getResourceAsStream("/simulation.properties"));
	}

	private void readSimulationValues() {
		maxNumberOfClients = Integer.parseInt(config.getProperty("client.max_number"));
		maxClientSpawnTime = Integer.parseInt(config.getProperty("client.max_spawn_time"));
	}

	private void logIntroduction() {
		String decoration = "************";
		logger.debug("\n{}\nProperties read:\nNumber of clients: {}\nMax client spawn time: {}\nMax cooking time: {}\n" +
				"Max order taking time: {}\nMax delivery time: {}\n{}",
				decoration, maxNumberOfClients, maxClientSpawnTime,
				chef.getCookingSpeed(), waiter.getOrderTakingSpeed(), waiter.getDeliverySpeed(), decoration);
		logger.info("{} Welcome to this Restaurant simulator! {}\n", decoration, decoration);
	}

}
