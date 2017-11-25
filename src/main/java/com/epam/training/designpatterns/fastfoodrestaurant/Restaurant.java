package com.epam.training.designpatterns.fastfoodrestaurant;

import com.epam.training.designpatterns.fastfoodrestaurant.staff.Server;
import com.epam.training.designpatterns.fastfoodrestaurant.staff.StaffFactory;
import com.epam.training.designpatterns.fastfoodrestaurant.tables.ClientFactory;

public class Restaurant {
    private static final int MAXCLIENTS = 30;
    private static final int ORDER_CAPACITY = 10;
    private static final int PLATE_CAPACITY = 15;
    private static final int SIMULATION_SPEED = 10; //lower is faster

    public static void main(String args[]) {
        StaffFactory staffFactory = new StaffFactory(ORDER_CAPACITY, PLATE_CAPACITY, SIMULATION_SPEED);
        try {
            Server server = staffFactory.startServing();
            ClientFactory clientFactory = new ClientFactory(server, MAXCLIENTS, SIMULATION_SPEED);
            staffFactory.startCooking();
            clientFactory.openDoors();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }




}