package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Observable;

import com.epam.training.designpatterns.fastfoodrestaurant.food.ExtraType;
import com.epam.training.designpatterns.fastfoodrestaurant.food.FoodType;

public class Order extends Observable{
    private FoodType food;
    private ExtraType extra;

    public Order(Client client, FoodType food, ExtraType extra) {
        addObserver(client);
        this.food = food;
        this.extra = extra;        
    }

    public FoodType getFood() {
        return food;
    }

    public ExtraType getExtra() {
        return extra;
    }

    public void setDone() {
        setChanged();
        notifyObservers();
        clearChanged();
    }
}