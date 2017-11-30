package com.epam.training.designpatterns.fastfoodrestaurant;

public class Ketchup extends Extra{

    public Ketchup(Food food) {
        super(food);
    }

    public double effect(double happines) {
        return food.effect(happines) * 2;
    }
}