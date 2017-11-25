package com.epam.training.designpatterns.fastfoodrestaurant.staff;

import com.epam.training.designpatterns.fastfoodrestaurant.tables.Client;
import com.epam.training.designpatterns.fastfoodrestaurant.foods.Food;

import java.util.Queue;

public class Server {
    private Queue<Order> orderQueue;
    private Queue<Order> platesReadyToServe;
    public Server(Queue<Order> orderQueue, Queue<Order> platesReadyToServe) {
        this.orderQueue = orderQueue;
        this.platesReadyToServe = platesReadyToServe;
    }

    public void requestFood(Client client, Food food){
        orderQueue.add(new Order(client, food));
    }

    public void serveFood(){
        Order plate = platesReadyToServe.remove();
        plate.getClient().eatFood(plate.getFood());
    }

}
