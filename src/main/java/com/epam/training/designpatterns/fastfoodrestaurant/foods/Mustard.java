package com.epam.training.designpatterns.fastfoodrestaurant.foods;

public class Mustard extends Condiment {
    public Mustard(Food food) {
        super(food);
    }

    @Override
    public double directHappiness(){
        return 1;
    }
    @Override
    public double modifyHappiness(){
        return 1;
    }
}
