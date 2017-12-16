package com.epam.training.designpatterns.fastfoodrestaurant;

public class Client {

    public Order createOrder() {
        Food baseFood = new Hotdog();
        Food extra = new Ketchup(baseFood);

        // Az étel elkészítése már itt megtörténik, de a feladat szerint a szakácsnak kellene elkészítenie

        return new Order(this, baseFood, extra);
    }
}
