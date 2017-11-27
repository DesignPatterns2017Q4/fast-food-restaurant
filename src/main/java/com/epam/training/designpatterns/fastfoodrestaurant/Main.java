package com.epam.training.designpatterns.fastfoodrestaurant;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        Chef chef = new Chef();
        
        Order order = client.makeOrder();
        Food food = chef.makeFood(order);
        client.eatFood(food);
    }    
}