package com.epam.training.designpatterns.fastfoodrestaurant.config;

import com.epam.training.designpatterns.fastfoodrestaurant.entities.Restaurant;
import com.epam.training.designpatterns.fastfoodrestaurant.simulation.RestaurantSimulator;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.Chef;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.DeliveryQueue;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.OrderQueue;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.Waiter;

import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {

    private static final int DEFAULT_ORDER_TAKING_SPEED = 9000;
    private static final int DEFAULT_DELIVERY_SPEED = 7000;
    private static final int DEFAULT_COOKING_SPEED = 7000;

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
        waiter.setOrderTakingSpeed(DEFAULT_ORDER_TAKING_SPEED);
        waiter.setDeliverySpeed(DEFAULT_DELIVERY_SPEED);
        return waiter;
    }

    @Bean
    Chef chef() {
        Chef chef = new Chef(orderQueue(), deliveryQueue());
        chef.setCookingSpeed(DEFAULT_COOKING_SPEED);
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
