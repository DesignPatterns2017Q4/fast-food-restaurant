package com.epam.training.designpatterns.fastfoodrestaurant;

public class Chef {

    public Food prepare(Order order) {

        System.out.println("Preparing order: " + order);
        Food baseFood = order.getFood();
        Food extra = order.getExtra();
        return extra;

        // Az étel már elkészült akkor, amikor a rendelés, a szakács igazából semmit nem csinál, a baseFood
        // átadása is felesleges
    }
}
