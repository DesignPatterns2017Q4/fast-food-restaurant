package com.epam.training.designpatterns.fastfoodrestaurant;

public class Mustard extends Extra{

    public Mustard(Food food) {
        super(food);
    }

    public double effect(double happines) {
        return happines + 1;
    }    
}