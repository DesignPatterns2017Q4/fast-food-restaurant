package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Queue;

public class Waiter{
    private Chef chef;
    private Queue<Order> orders;

    public Waiter(Chef chef, Queue<Order> orders) {
        this.chef = chef;
        this.orders = orders;
    }

    public Food getFood() {
        System.out.println("Waiter: Getting the food from the chef.");
        return chef.getFood();
    }

    public void addOrder(Order order) {
        System.out.println("Waiter: Adding the order on the queue.");
        orders.add(order);
    }
}