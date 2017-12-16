package com.epam.training.designpatterns.fastfoodrestaurant;

public class Hotdog implements Food {

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
