package com.epam.training.designpatterns.fastfoodrestaurant;

public class Client {

    public Order createOrder() {

        // Kétféle hotdog és kétféle ketchup van:
        // 1. Az étlapon szereplő választási lehetőség, ami enumban van, csak egy példány lesz belőlük, nem is kell több
        // 2. Maga az étel, amiből minden vendégnek külön példányt kell készíteni
        return new Order(this, FoodChoice.HOTDOG, ExtraChoice.KETCHUP);
    }
}
