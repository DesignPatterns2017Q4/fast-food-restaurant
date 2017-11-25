package com.epam.training.designpatterns.fastfoodrestaurant.staff;

import java.util.concurrent.ArrayBlockingQueue;

public class StaffFactory {
    private ArrayBlockingQueue<Order> orders;
    private ArrayBlockingQueue<Order> platesReadyToServe;
    private final int simulation_speed;

    public StaffFactory(int maxOrders, int maxPlates, int simulation_speed) {
        this.orders = new ArrayBlockingQueue<>(maxOrders);
        this.platesReadyToServe = new ArrayBlockingQueue<>(maxPlates);
        this.simulation_speed = simulation_speed;
    }

    public void startCooking(){
        new Thread(new Cook(orders, platesReadyToServe, simulation_speed)).start();
    }
    public Server startServing(){
        Server server = new Server(orders, platesReadyToServe, simulation_speed);
        new Thread(server).start();
        return server;
    }
}
