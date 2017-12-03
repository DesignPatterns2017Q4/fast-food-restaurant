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
        return chef.getFood();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}