package com.epam.training.designpatterns.fastfoodrestaurant;

public class Order {
    private Menu.FoodType food;
    private Menu.ExtraType extra;

    public Order(Menu.FoodType food, Menu.ExtraType extra) {
        this.food = food;
        this.extra = extra;
    }

    public Menu.FoodType getFood() {
        return food;
    }

    public Menu.ExtraType getExtra() {
        return extra;
    }
}