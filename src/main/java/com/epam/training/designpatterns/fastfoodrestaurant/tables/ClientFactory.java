package com.epam.training.designpatterns.fastfoodrestaurant.tables;

import com.epam.training.designpatterns.fastfoodrestaurant.staff.Server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ClientFactory {
    private final int simulation_speed;
    private final Server server;
    private Semaphore sema;

    public ClientFactory(Server server, int maxClients, int simulation_speed) {
        this.server = server;
        this.sema = new Semaphore(maxClients);
        this.simulation_speed = simulation_speed;
    }

    public void openDoors() throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        while (true) {
            Thread.sleep(5 * simulation_speed);
            service.submit(newClient());
        }
    }

    private Client newClient() throws InterruptedException {
        if (sema.availablePermits() == 0) {
            System.err.println("Restaurant has no more free seats");
        }
        sema.acquire();
        Client client = new Client(server, sema, simulation_speed);
        System.out.println(client.toString() + " has entered the restaurant");
        return client;
    }
}
