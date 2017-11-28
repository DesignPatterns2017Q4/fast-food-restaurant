package com.epam.training.designpatterns.fastfoodrestaurant;

public class Waiter {
    private Chef chef;

    public Waiter(Chef chef) {
        this.chef = chef;
    }

    public Food addOrder(Order order) {
        return chef.makeFood(order);
    }
    
}