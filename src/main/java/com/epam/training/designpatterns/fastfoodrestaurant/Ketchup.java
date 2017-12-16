package com.epam.training.designpatterns.fastfoodrestaurant;

public class Ketchup implements Food {

    private Food baseFood;

    public Ketchup(Food baseFood) {
        this.baseFood = baseFood;
    }

    public Food getBaseFood() {
        return baseFood;
    }

    @Override
    public String toString() {
        return "Ketchup{" +
                "baseFood=" + baseFood +
                '}';
    }
}
