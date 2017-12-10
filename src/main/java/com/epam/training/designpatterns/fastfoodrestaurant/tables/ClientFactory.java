package com.epam.training.designpatterns.fastfoodrestaurant.tables;

import com.epam.training.designpatterns.fastfoodrestaurant.Restaurant;
import com.epam.training.designpatterns.fastfoodrestaurant.staff.Server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ClientFactory {
    private final int simulation_speed;
    private final Server server;
    private final Restaurant restaurant;

    public ClientFactory(Server server, Restaurant restaurant, int simulation_speed) {
        this.server = server;
        this.restaurant = restaurant;
        this.simulation_speed = simulation_speed;
    }

    public void openDoors() throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        while (true) {
            Thread.sleep(5 * simulation_speed);
            service.submit(new Client(server, restaurant, simulation_speed));
        }
    }
}
