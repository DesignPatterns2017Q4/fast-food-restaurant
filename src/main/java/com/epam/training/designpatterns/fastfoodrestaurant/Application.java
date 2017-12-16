package com.epam.training.designpatterns.fastfoodrestaurant;

public class Application {

    public static void main(String[] args) {

        Client client = new Client();
        Order order = client.createOrder();
        Chef chef = new Chef();
        Food preparedFood = chef.prepare(order);

        System.out.println("preparedFood: " + preparedFood);
    }
}
