package com.epam.training.designpatterns.fastfoodrestaurant.food;

public class Chips implements Food {
    public double effect(double happines) {
        return happines * 1.05;
    }
}