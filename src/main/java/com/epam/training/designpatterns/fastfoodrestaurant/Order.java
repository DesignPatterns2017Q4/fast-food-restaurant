package com.epam.training.designpatterns.fastfoodrestaurant;

public class Order {

    private final Client client;
    private final Food food;
    private final Food extra;

    public Order(Client client, Food food, Food extra) {
        this.client = client;
        this.food = food;
        this.extra = extra;
    }

    public Client getClient() {
        return client;
    }

    public Food getFood() {
        return food;
    }

    public Food getExtra() {
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
