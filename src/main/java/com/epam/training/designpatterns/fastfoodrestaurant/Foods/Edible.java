package com.epam.training.designpatterns.fastfoodrestaurant.Foods;

public class Edible implements Food{
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
