package com.epam.training.designpatterns.fastfoodrestaurant.staff;

import com.epam.training.designpatterns.fastfoodrestaurant.foods.Food;
import com.epam.training.designpatterns.fastfoodrestaurant.tables.Client;

import java.util.List;

/**
 * Contains the order for a given client
 */
public class Order {
    private Client client;
    private List<String> foodOrder;

    Order(Client client, List<String> foodOrder) {
        this.client = client;
        this.foodOrder = foodOrder;
    }

    public List<String> getFoods() {
        return foodOrder;
    }

    @Override
    public String toString() {
        return "Order for " + client + ": " + String.join(" and ",foodOrder);
    }

    Client getClient() {
        return client;
    }
}
