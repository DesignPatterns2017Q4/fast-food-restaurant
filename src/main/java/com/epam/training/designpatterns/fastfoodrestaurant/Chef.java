package com.epam.training.designpatterns.fastfoodrestaurant;

public class Chef {
    public Food makeFood(Order order) {
        Food resultFood;
        
        if (order.getFood() ==  Menu.FoodType.Hotdog ) {
            resultFood = new Hotdog();
        } else {
            resultFood = new Chips();
        }


        if(order.getExtra() == Menu.ExtraType.Ketchup) {
            resultFood = new Ketchup(resultFood);
        } else {
            resultFood = new Mustard(resultFood);
        }

        return resultFood;
    }
}