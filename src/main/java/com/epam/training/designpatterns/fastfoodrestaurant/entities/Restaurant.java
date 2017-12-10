package com.epam.training.designpatterns.fastfoodrestaurant.entities;

import com.epam.training.designpatterns.fastfoodrestaurant.simulation.RestaurantSimulator;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.Chef;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.DeliveryQueue;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.OrderQueue;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.Waiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class Restaurant {

    private static final int DEFAULT_SPEED = 3000;
    private static final String DEFAULT_PROPERTIES_FILE = "/restaurant.properties";
    private static final Logger logger = LoggerFactory.getLogger("Restaurant");
    private Properties config;

    private OrderQueue orderQueue;
    private DeliveryQueue deliveryQueue;
    private Chef chef;
    private Waiter waiter;

    public Restaurant(OrderQueue orderQueue, DeliveryQueue deliveryQueue, Waiter waiter, Chef chef) {
        Objects.requireNonNull(orderQueue);
        Objects.requireNonNull(deliveryQueue);
        Objects.requireNonNull(waiter);
        Objects.requireNonNull(chef);

        this.orderQueue = orderQueue;
        this.deliveryQueue = deliveryQueue;
        this.waiter = waiter;
        this.chef = chef;
    }

    public Restaurant() throws IOException {
        this(DEFAULT_PROPERTIES_FILE);
    }

    public Restaurant(String propertiesFilePath) throws IOException {
        this.orderQueue = new OrderQueue();
        this.deliveryQueue = new DeliveryQueue();
        this.waiter = new Waiter(orderQueue, deliveryQueue);
        this.chef = new Chef(orderQueue, deliveryQueue);

        openConfigFile(propertiesFilePath);
        setSpeedFromConfigOrDefault();
    }
    private void setSpeedFromConfigOrDefault() {
        int orderTakingSpeed = DEFAULT_SPEED;
        int deliverySpeed = DEFAULT_SPEED;
        int cookingSpeed = DEFAULT_SPEED;
        try {
            orderTakingSpeed = Integer.parseInt(config.getProperty("waiter.order_speed"));
            deliverySpeed = Integer.parseInt(config.getProperty("waiter.delivery_speed"));
            cookingSpeed = Integer.parseInt(config.getProperty("chef.cooking_speed"));
        }
        catch (NumberFormatException e) {
            logger.error("Error during reading speed config variables: " + e.getMessage());
        }
        waiter.setOrderTakingSpeed(orderTakingSpeed);
        waiter.setDeliverySpeed(deliverySpeed);
        chef.setCookingSpeed(cookingSpeed);
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

    private void openConfigFile(String propFilePath) throws IOException {
        config = new Properties();
        config.load(RestaurantSimulator.class.getResourceAsStream(propFilePath));
    }
}
