package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Queue;

public class Chef {
    private Queue<Order> orders;
    private Food food;


    public Chef(Queue<Order> orders) {
        this.orders = orders;
    }

    public void makeFood() {
        Order order = orders.remove();
        
        
        if (order.getFood() ==  Menu.FoodType.Hotdog ) {
            food = new Hotdog();
        } else {
            food = new Chips();
        }


        if(order.getExtra() == Menu.ExtraType.Ketchup) {
            food = new Ketchup(food);
        } else {
            food = new Mustard(food);
        }
        order.setDone();
    }

    public Food getFood() {
        return food;
    }
}