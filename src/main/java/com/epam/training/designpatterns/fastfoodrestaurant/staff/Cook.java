package com.epam.training.designpatterns.fastfoodrestaurant.staff;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Takes orders from the order queue, prepares the food, and puts the cooked food in the ready queue
 */
public class Cook implements Runnable {
    private final int SIMULATION_SPEED;
    private ArrayBlockingQueue<Order> orders;
    private ArrayBlockingQueue<Order> platesReadyToServe;

    Cook(ArrayBlockingQueue<Order> orders, ArrayBlockingQueue<Order> platesReadyToServe, int simulation_speed) {
        this.orders = orders;
        this.platesReadyToServe = platesReadyToServe;
        SIMULATION_SPEED = simulation_speed;
    }

    @Override
    public void run() {
        try {
            cookFood();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void cookFood() throws InterruptedException {
        while (true) {
            Order order = orders.take();
            System.out.println(String.format("Cooking %s ", order.toString()));
            Thread.sleep(15 * SIMULATION_SPEED);
            Order plate = new Order(order.getClient(), order.getFood());

            if (platesReadyToServe.remainingCapacity() == 0) {
                System.err.println("Restaurant has run out of plates to serve");
            }

            platesReadyToServe.put(plate);
        }
    }
}