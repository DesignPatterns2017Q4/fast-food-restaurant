package com.epam.training.designpatterns.fastfoodrestaurant.config;

import com.epam.training.designpatterns.fastfoodrestaurant.entities.Restaurant;
import com.epam.training.designpatterns.fastfoodrestaurant.simulation.RestaurantSimulator;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.Chef;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.DeliveryQueue;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.OrderQueue;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.Waiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("/restaurant.properties")
public class AppConfig {

    private static final int DEFAULT_ORDER_TAKING_SPEED = 9000;
    private static final int DEFAULT_DELIVERY_SPEED = 7000;
    private static final int DEFAULT_COOKING_SPEED = 7000;

    @Autowired
    Environment environment;

    @Bean
    OrderQueue orderQueue() {
        return new OrderQueue();
    }

    @Bean
    DeliveryQueue deliveryQueue() {
        return new DeliveryQueue();
    }

    @Bean
    Waiter waiter() {
        Waiter waiter = new Waiter(orderQueue(), deliveryQueue());
        waiter.setOrderTakingSpeed(Integer.parseInt(environment.getProperty("waiter.order_speed")));
        waiter.setDeliverySpeed(Integer.parseInt(environment.getProperty("waiter.delivery_speed")));
        return waiter;
    }

    @Bean
    Chef chef() {
        Chef chef = new Chef(orderQueue(), deliveryQueue());
        chef.setCookingSpeed(Integer.parseInt(environment.getProperty("chef.cooking_speed")));
        return chef;
    }

    @Bean
    public Restaurant restaurant() {
        return new Restaurant(orderQueue(), deliveryQueue(), waiter(), chef());
    }

    @Bean
    public RestaurantSimulator restaurantSimulator() {
        return new RestaurantSimulator(restaurant());
    }

}
