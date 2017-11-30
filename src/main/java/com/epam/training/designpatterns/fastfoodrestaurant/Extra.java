package com.epam.training.designpatterns.fastfoodrestaurant;

public abstract class Extra implements Food {
    Food food;

    public Extra(Food food) {
        this.food = food;
    }
}