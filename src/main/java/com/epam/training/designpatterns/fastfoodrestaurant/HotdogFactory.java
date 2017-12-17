package com.epam.training.designpatterns.fastfoodrestaurant;

public class HotdogFactory implements FoodFactory {

    @Override
    public Food create() {
        return new Hotdog();
    }
}
