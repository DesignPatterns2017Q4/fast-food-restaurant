package com.epam.training.designpatterns.fastfoodrestaurant;

public class Waiter{
    private Chef chef;
    private Food food;

    public Waiter(Chef chef) {
        this.chef = chef;
    }

    public void giveOrderToChef(Order order) {
        food = chef.makeFood(order);
        order.setDone();
    }

    public Food getFood() {
        return food;
    }
}