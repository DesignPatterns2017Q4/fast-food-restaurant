package com.epam.training.designpatterns.fastfoodrestaurant;

import com.epam.training.designpatterns.fastfoodrestaurant.foods.Menu;
import com.epam.training.designpatterns.fastfoodrestaurant.staff.Server;
import com.epam.training.designpatterns.fastfoodrestaurant.staff.StaffFactory;
import com.epam.training.designpatterns.fastfoodrestaurant.tables.ClientFactory;

import java.util.concurrent.Semaphore;


public class Restaurant {
    private static final int MAXCLIENTS = 30;
    private static final int ORDER_CAPACITY = 20;
    private static final int PLATE_CAPACITY = 15;
    private static final int SIMULATION_SPEED = 10; //lower is faster
    private static final Semaphore semaphore= new Semaphore(MAXCLIENTS);
    public void main(String args[]) {
        StaffFactory staffFactory = new StaffFactory(ORDER_CAPACITY, PLATE_CAPACITY, SIMULATION_SPEED);
        try {
            Server server = staffFactory.startServing();
            ClientFactory clientFactory = new ClientFactory(server, this, SIMULATION_SPEED);
            staffFactory.startCooking();
            clientFactory.openDoors();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public Menu enter() throws InterruptedException {
        if (semaphore.availablePermits() == 0) {
            System.err.println("Restaurant has no more free seats");
        }
        semaphore.acquire();
        return Menu.getInstance();
    }
    public void leave() {
        semaphore.release();
    }
}
