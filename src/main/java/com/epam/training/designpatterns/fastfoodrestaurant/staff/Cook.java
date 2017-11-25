package com.epam.training.designpatterns.fastfoodrestaurant.staff;

import java.util.Queue;

public class Cook {
    private Queue<Order> orders;
    private Queue<Order> platesReadyToServe;
    public Cook(Queue<Order> orders, Queue<Order> platesReadyToServe){
        this.orders = orders;
        this.platesReadyToServe = platesReadyToServe;
    }

    public void cookFood(){
        Order order = orders.remove();
        System.out.println(String.format("Cooking %s ", order.toString()));
        order.getFood().prepare();
        Order plate = new Order(order.getClient(), order.getFood());
        platesReadyToServe.add(plate);
    }

}
