package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Order> orders = new LinkedList<Order>();
        Chef chef = new Chef(orders);
        Waiter waiter = new Waiter(chef, orders);
        
        Client client1 = new Client(waiter, Menu.FoodType.Hotdog, Menu.ExtraType.Ketchup);
        Client client2 = new Client(waiter, Menu.FoodType.Chips, Menu.ExtraType.Mustard);
        
        Order order1 = client1.makeOrder();
        Order order2 = client2.makeOrder();
        waiter.addOrder(order1);
        waiter.addOrder(order2);
        chef.makeFood();
        chef.makeFood();
    }    
}