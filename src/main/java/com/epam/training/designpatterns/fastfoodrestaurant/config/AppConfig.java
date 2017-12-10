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

    public static final int DEFAULT_SPEED = 8000;

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
        waiter.setOrderTakingSpeed(DEFAULT_SPEED);
        waiter.setDeliverySpeed(DEFAULT_SPEED);
        return waiter;
    }

    @Bean
    Chef chef() {
        Chef chef = new Chef(orderQueue(), deliveryQueue());
        chef.setCookingSpeed(DEFAULT_SPEED);
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
