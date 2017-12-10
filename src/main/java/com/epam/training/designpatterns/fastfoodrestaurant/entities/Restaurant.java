package com.epam.training.designpatterns.fastfoodrestaurant.entities;

import com.epam.training.designpatterns.fastfoodrestaurant.simulation.RestaurantSimulator;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.Chef;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.DeliveryQueue;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.OrderQueue;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.Waiter;

import java.io.IOException;
import java.util.Properties;

public class Restaurant {

    public static final String DEFAULT_PROPERTIES_FILE = "/restaurant.properties";
    private Properties config;

    private OrderQueue orderQueue;
    private DeliveryQueue deliveryQueue;
    private Chef chef;
    private Waiter waiter;

    public Restaurant() throws IOException {
        openConfigFile(DEFAULT_PROPERTIES_FILE);
        createWorkStations();
    }

    public Restaurant(String propertiesFilePath) throws IOException {
        openConfigFile(propertiesFilePath);
        createWorkStations();
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public int getCookingSpeed() {
        return chef.getCookingSpeed();
    }

    public int getOrderTakingSpeed() {
        return waiter.getOrderTakingSpeed();
    }

    public int getDeliverySpeed() {
        return waiter.getDeliverySpeed();
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

    private void openConfigFile(String propFilePath) throws IOException {
        config = new Properties();
        config.load(RestaurantSimulator.class.getResourceAsStream(propFilePath));
    }
}
