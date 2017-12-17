package com.epam.training.designpatterns.fastfoodrestaurant;

public class KetchupFactory implements ExtraFactory {

    @Override
    public Food create(Food baseFood) {
        return new Ketchup(baseFood);
    }
}
