package com.epam.training.designpatterns.fastfoodrestaurant.foods;

/**
 * Decorator for Foods. Doesn't add functionality, but may modify behaviors
 */
public abstract class Condiment implements Food {

    Food food;

    public Condiment(Food food) {
        this.food = food;
    }

    @Override
    public double directHappiness() {
        return food.directHappiness();
    }

    @Override
    public double modifyHappiness() {
        return food.modifyHappiness();
    }


    @Override
    public void prepare() {
        food.prepare();
    }

    @Override
    public boolean isPrepared() {
        return food.isPrepared();
    }


    @Override
    public String toString() {
        return food + " and " + this.getClass().getSimpleName();
    }
}
