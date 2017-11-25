package com.epam.training.designpatterns.fastfoodrestaurant.foods;

public class Ketchup extends Condiment {
    public Ketchup(Food food) {
        super(food);
    }

    @Override
    public double directHappiness(){
        return food.directHappiness() * 2;
    }
}
