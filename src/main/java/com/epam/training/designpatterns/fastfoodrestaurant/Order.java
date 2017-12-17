package com.epam.training.designpatterns.fastfoodrestaurant;

public class Order {

    private final Client client;
    private final String food;
    private final String extra;

    public Order(Client client, String food, String extra) {
        this.client = client;
        this.food = food;
        this.extra = extra;
    }

    public Client getClient() {
        return client;
    }

    public String getFood() {
        return food;
    }

    public String getExtra() {
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
