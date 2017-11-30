package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Observable;
import java.util.Observer;

public class Client implements Observer{
    private double happines = 0.0;
    private Menu.FoodType food;
    private Menu.ExtraType extra;
    private Waiter waiter;

    public Client(Waiter waiter, Menu.FoodType food, Menu.ExtraType extra) {
        this.waiter = waiter;
        this.food = food;
        this.extra = extra;
    }

    public Order makeOrder() {
        return new Order(this, food, extra);
    }

    public double eatFood(Food food) {
        return food.effect(happines);
    }

    public void update(Observable o, Object arg) {
        Food food = waiter.getFood();
        System.out.println("Client happines: " + eatFood(food));
    }
}
