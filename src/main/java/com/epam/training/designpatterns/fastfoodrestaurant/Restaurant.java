package com.epam.training.designpatterns.fastfoodrestaurant;


import com.epam.training.designpatterns.fastfoodrestaurant.Staff.Cook;
import com.epam.training.designpatterns.fastfoodrestaurant.Staff.Order;
import com.epam.training.designpatterns.fastfoodrestaurant.Staff.Server;

import java.util.LinkedList;
import java.util.Queue;

public class Restaurant {
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