package com.epam.training.designpatterns.fastfoodrestaurant.staff;

import com.epam.training.designpatterns.fastfoodrestaurant.foods.Food;
import com.epam.training.designpatterns.fastfoodrestaurant.tables.Client;

public class Plate {
    private Food food;
    private Client client;

    public Plate(Food food, Client client) {
        this.food = food;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public Food getFood() {
        return food;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                ", client=" + client +
                '}';
    }
}
