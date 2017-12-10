package com.epam.training.designpatterns.fastfoodrestaurant.simulation;

import com.epam.training.designpatterns.fastfoodrestaurant.entities.Client;
import com.epam.training.designpatterns.fastfoodrestaurant.entities.Order;
import com.epam.training.designpatterns.fastfoodrestaurant.food.*;
import com.epam.training.designpatterns.fastfoodrestaurant.strategies.AmericanStyleCookingStrategy;
import com.epam.training.designpatterns.fastfoodrestaurant.strategies.CookingStrategy;
import com.epam.training.designpatterns.fastfoodrestaurant.strategies.JapaneseStyleCookingStrategy;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.Waiter;

import java.util.Random;

public class SimulatedClient implements Runnable {

    private static final Random random = new Random();
    private final Waiter waiter;

    public SimulatedClient(Waiter waiter) {
        this.waiter = waiter;
    }

    @Override
    public void run() {
        Client client = new Client(waiter);
        Order order = generateRandomOrder(client);
        client.orderFood(order);
    }

    private Order generateRandomOrder(Client client) {
        return new Order.OrderBuilder(client, createRandomFood())
                .withCondiment(createRandomCondiment())
                .withCookingStyle(createRandomCookingStrategy())
                .withPriority(createRandomPriority())
                .build();
    }

    private boolean rollTheDice() {
        return random.nextInt(100) > 50;
    }

    private Food createRandomFood() {
        return rollTheDice() ? new Chips() : new Hotdog();
    }

    private Class<? extends Condiment> createRandomCondiment() {
        return rollTheDice() ? Ketchup.class : Mustard.class;
    }

    private CookingStrategy createRandomCookingStrategy() {
        return rollTheDice() ? new AmericanStyleCookingStrategy() : new JapaneseStyleCookingStrategy();
    }

    private boolean createRandomPriority() {
        return rollTheDice();
    }
}