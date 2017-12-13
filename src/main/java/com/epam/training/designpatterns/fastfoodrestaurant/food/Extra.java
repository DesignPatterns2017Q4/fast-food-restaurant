package com.epam.training.designpatterns.fastfoodrestaurant.food;

public abstract class Extra implements Food {
    Food food;

    public Extra(Food food) {
        this.food = food;
    }
}