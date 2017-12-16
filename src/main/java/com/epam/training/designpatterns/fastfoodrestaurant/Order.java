package com.epam.training.designpatterns.fastfoodrestaurant;

public class Order {

    private final Client client;
    private final Class food;
    private final Class extra;

    public Order(Client client, Class food, Class extra) {
        this.client = client;
        this.food = food;
        this.extra = extra;
    }

    public Client getClient() {
        return client;
    }

    public Class getFood() {
        return food;
    }

    public Class getExtra() {
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
