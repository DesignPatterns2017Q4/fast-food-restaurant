package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Observable;
import java.util.Observer;

import com.epam.training.designpatterns.fastfoodrestaurant.food.ExtraType;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Food;
import com.epam.training.designpatterns.fastfoodrestaurant.food.FoodType;

public class Client implements Observer{
    private double happines = 0.0;
    private FoodType food;
    private ExtraType extra;
    private Waiter waiter;

    public Client(Waiter waiter, FoodType food, ExtraType extra) {
        this.waiter = waiter;
        this.food = food;
        this.extra = extra;
    }

    public Order makeOrder() {
        System.out.println("Client: I want a " + food + " with " + extra);
        return new Order(this, food, extra);
    }

    public double eatFood(Food food) {
        System.out.println("Client: I'm eating.");
        happines = food.effect(happines);
        return happines;
    }

    public void update(Observable o, Object arg) {
        System.out.println("Client: My food is ready! I will get my food form my waiter.");
        Food food = waiter.getFood();
        System.out.println("Client: My happines is " + eatFood(food));
    }
}
