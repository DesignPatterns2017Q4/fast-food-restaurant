package com.epam.training.designpatterns.fastfoodrestaurant;

public class Client {
    private double happines = 0.0;

    public Order makeOrder() {
        return new Order();
    }

    public void eatFood(Food food) {
        happines++;
    }
}
