package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Order> orders = new LinkedList<Order>();
        
        Chef chef = new Chef(orders);
        Waiter waiter = new Waiter(chef, orders);
        Client client = new Client(waiter, Menu.FoodType.Hotdog, Menu.ExtraType.Ketchup);
        
        Order order = client.makeOrder();
        waiter.addOrder(order);
        chef.makeFood();
    }    
}