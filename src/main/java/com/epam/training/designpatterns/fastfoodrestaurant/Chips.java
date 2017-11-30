package com.epam.training.designpatterns.fastfoodrestaurant;

public class Chips implements Food {
    public double effect(double happines) {
        return happines * 1.05;
    }
}