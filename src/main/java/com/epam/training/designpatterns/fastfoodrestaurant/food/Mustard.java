package com.epam.training.designpatterns.fastfoodrestaurant.food;

public class Mustard extends Extra{

    public Mustard(Food food) {
        super(food);
    }

    public double effect(double happines) {
        return happines + 1;
    }    
}