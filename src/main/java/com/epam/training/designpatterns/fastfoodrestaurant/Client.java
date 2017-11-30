package com.epam.training.designpatterns.fastfoodrestaurant;

public class Client {
    private double happines = 0.0;
    private Menu.FoodType food;
    private Menu.ExtraType extra;

    public Client(Menu.FoodType food, Menu.ExtraType extra) {
        this.food = food;
        this.extra = extra;
    }

    public Order makeOrder() {
        return new Order(food, extra);
    }

    public double eatFood(Food food) {
        return food.effect(happines);
    }
}
