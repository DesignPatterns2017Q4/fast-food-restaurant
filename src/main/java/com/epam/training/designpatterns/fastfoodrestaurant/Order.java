package com.epam.training.designpatterns.fastfoodrestaurant;

public class Order {

    private final Client client;
    private final FoodChoice food;
    private final ExtraChoice extra;

    public Order(Client client, FoodChoice food, ExtraChoice extra) {
        this.client = client;
        this.food = food;
        this.extra = extra;
    }

    public Client getClient() {
        return client;
    }

    public FoodChoice getFood() {
        return food;
    }

    public ExtraChoice getExtra() {
        return extra;
    }

    @Override
    public String toString() {
        return "Order{" +
                "client=" + client +
                ", food=" + food +
                ", extra=" + extra +
                '}';
    }
}
