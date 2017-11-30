package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Observable;

public class Order extends Observable{
    private Menu.FoodType food;
    private Menu.ExtraType extra;

    public Order(Client client, Menu.FoodType food, Menu.ExtraType extra) {
        addObserver(client);
        this.food = food;
        this.extra = extra;        
    }

    public Menu.FoodType getFood() {
        return food;
    }

    public Menu.ExtraType getExtra() {
        return extra;
    }

    public void setDone() {
        setChanged();
        notifyObservers();
        clearChanged();
    }
}