package com.epam.training.designpatterns.fastfoodrestaurant;


import com.epam.training.designpatterns.fastfoodrestaurant.staff.Cook;
import com.epam.training.designpatterns.fastfoodrestaurant.staff.Order;
import com.epam.training.designpatterns.fastfoodrestaurant.staff.Server;
import com.epam.training.designpatterns.fastfoodrestaurant.tables.Client;

import java.util.LinkedList;
import java.util.Queue;

public class Restaurant {
    public static final int MAXCLIENTS = 20;

    public static void main(String args[]) {
        Queue<Order> orderQueue = new LinkedList<>();
        Queue<Order> plateQueue = new LinkedList<>();
        Server server = new Server(orderQueue, plateQueue);
        Cook cook = new Cook(orderQueue, plateQueue);
        Client client = new Client(server);
        client.orderFood();
        cook.cookFood();
        server.serveFood();
    }
}