package com.epam.training.designpatterns.fastfoodrestaurant.foods;

/**
 * Implements some methods common for all foods
 */
public abstract class Edible implements Food {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
