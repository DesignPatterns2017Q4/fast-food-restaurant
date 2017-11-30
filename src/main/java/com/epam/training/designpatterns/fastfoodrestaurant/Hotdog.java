package com.epam.training.designpatterns.fastfoodrestaurant;

public class Hotdog implements Food {
    public double effect(double happines) {
        return happines + 2;
    }
}