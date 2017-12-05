package com.epam.training.designpatterns.fastfoodrestaurant.staff;

import com.epam.training.designpatterns.fastfoodrestaurant.foods.Food;
import com.epam.training.designpatterns.fastfoodrestaurant.tables.Client;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Acts as a mediator between clients and the queues
 * Also an observer, lets the client know when food is ready
 */
public class Server implements Runnable {
    private final int SIMULATION_SPEED;
    private ArrayBlockingQueue<Order> platesReadyToServe;
    private ArrayBlockingQueue<Order> orderQueue;

    public Server(ArrayBlockingQueue<Order> platesReadyToServe, ArrayBlockingQueue<Order> orderQueue, int simulation_speed) {
        this.platesReadyToServe = platesReadyToServe;
        this.orderQueue = orderQueue;
        SIMULATION_SPEED = simulation_speed;
    }

    public void takeOrder(Client client, Food food) throws InterruptedException {
        Thread.sleep(3 * SIMULATION_SPEED);

        if (orderQueue.remainingCapacity() == 0) {
            System.err.println("Restaurant has no capacity for more orders");
        }
        orderQueue.put(new Order(client, food));
    }

    @Override
    public void run() {
        try {
            serveFood();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void serveFood() throws InterruptedException {
        while (true) {
            Thread.sleep(2 * SIMULATION_SPEED);
            Order plate = platesReadyToServe.take();
            Client client = plate.getClient();
            synchronized (client) {
                client.giveFood(plate.getFood());
                client.notifyAll();
            }
        }
    }
}
