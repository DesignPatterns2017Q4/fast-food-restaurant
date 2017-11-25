package com.epam.training.designpatterns.fastfoodrestaurant.foods;

/**
 * Implements some methods common for all foods
 */
public abstract class Edible implements Food{
    private boolean prepared;
    @Override
    public void prepare() {
        prepared = true;
    }

    @Override
    public boolean isPrepared() {
        return prepared;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
