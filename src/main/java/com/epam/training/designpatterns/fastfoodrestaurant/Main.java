package com.epam.training.designpatterns.fastfoodrestaurant;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        Chef chef = new Chef();
        Waiter waiter = new Waiter(chef);
        
        Order order = client.makeOrder();
        Food food = waiter.addOrder(order);
        client.eatFood(food);
    }    
}