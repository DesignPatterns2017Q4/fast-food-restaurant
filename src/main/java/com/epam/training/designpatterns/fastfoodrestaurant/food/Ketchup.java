package com.epam.training.designpatterns.fastfoodrestaurant.food;

public class Ketchup extends Extra{

    public Ketchup(Food food) {
        super(food);
    }

    public double effect(double happines) {
        return food.effect(happines) * 2;
    }
}