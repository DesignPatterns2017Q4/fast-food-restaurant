package com.epam.training.designpatterns.fastfoodrestaurant;

public class Client {

    public Order createOrder() {
        // Az étel nincs elkészítve, csak a megfelelő class segítségével jelezzük, hogy miből kérünk példányt
        return new Order(this, Hotdog.class, Ketchup.class);
    }
}
