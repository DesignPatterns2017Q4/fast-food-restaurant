package com.epam.training.designpatterns.fastfoodrestaurant.staff;

import com.epam.training.designpatterns.fastfoodrestaurant.foods.Food;
import com.epam.training.designpatterns.fastfoodrestaurant.tables.Client;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Acts as a mediator between clients and the cook
 */
public class Server implements Runnable{
    private ArrayBlockingQueue<Order> orderQueue;
    private ArrayBlockingQueue<Order> platesReadyToServe;
    private final int SIMULATION_SPEED;
    public Server(ArrayBlockingQueue<Order> orderQueue, ArrayBlockingQueue<Order> platesReadyToServe, int simulation_speed) {
        this.orderQueue = orderQueue;
        this.platesReadyToServe = platesReadyToServe;
        SIMULATION_SPEED = simulation_speed;
    }

    /**
     * @param client requesting client
     * @param food to serve
     */
    public void takeOrder(Client client, Food food) throws InterruptedException {

        if (orderQueue.remainingCapacity() ==0){
            System.err.println("Restaurant has no capacity for more orders");
        }
        Thread.sleep(3 * SIMULATION_SPEED);
        orderQueue.put(new Order(client, food));
    }

    public void serveFood() throws InterruptedException {
        while (true) {
            Thread.sleep(2 * SIMULATION_SPEED);
            Order plate = platesReadyToServe.take();
            plate.getClient().giveFoodEatAndLeave(plate.getFood());
        }
    }

    @Override
    public void run() {
        try {
            serveFood();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
