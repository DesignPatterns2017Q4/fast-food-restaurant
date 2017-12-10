package com.epam.training.designpatterns.fastfoodrestaurant.simulation;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.epam.training.designpatterns.fastfoodrestaurant.entities.Restaurant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestaurantSimulator {

	private static final Logger logger = LoggerFactory.getLogger("RestaurantSimulator");
	private static final Random random = new Random();

	private Properties config;
	private int maxNumberOfClients;
	private int maxClientSpawnTime;

	private Restaurant restaurant;

	public static void main(String[] args) throws InterruptedException, IOException {
		RestaurantSimulator restaurant = new RestaurantSimulator();
		restaurant.openConfigFile();
		restaurant.readSimulationValues();
		restaurant.startSimulation();
	}

	private void startSimulation() throws InterruptedException, IOException {
		restaurant = new Restaurant();
		logIntroduction();
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < maxNumberOfClients; ++i) {
			executor.submit(new SimulatedClient(restaurant.getWaiter()));
			Thread.sleep(random.nextInt(maxClientSpawnTime));
		}
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
				restaurant.getCookingSpeed(), restaurant.getOrderTakingSpeed(),
				restaurant.getDeliverySpeed(), decoration);
		logger.info("\n{} Welcome to this Restaurant simulator! {}\n", decoration, decoration);
	}

}
