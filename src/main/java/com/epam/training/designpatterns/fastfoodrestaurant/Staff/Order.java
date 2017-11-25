package com.epam.training.designpatterns.fastfoodrestaurant.Staff;

import com.epam.training.designpatterns.fastfoodrestaurant.Client;
import com.epam.training.designpatterns.fastfoodrestaurant.Foods.Food;

public class Order {
    private Client client;

    public Food getFood() {
        return food;
    }

    private Food food;

    public Order(Client client){
        this.client = client;
    }
    public Order(Client client, Food food){
        this.client = client;
        this.food = food;
    }

    @Override
    public String toString() {
        return "Order for " + client + ": " + food;
    }

    public Client getClient() {
        return client;
    }
}
