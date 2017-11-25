package com.epam.training.designpatterns.fastfoodrestaurant.Foods;

public class Ketchup extends Condiment {
    public Ketchup(Food food) {
        super(food);
    }

    @Override
    public double directHappiness(){
        return food.directHappiness() * 2;
    }
}
