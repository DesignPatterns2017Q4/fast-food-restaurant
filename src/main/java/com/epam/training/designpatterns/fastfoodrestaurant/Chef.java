package com.epam.training.designpatterns.fastfoodrestaurant;

import java.lang.reflect.InvocationTargetException;

public class Chef {

    public Food prepare(Order order) {

        System.out.println("Preparing order: " + order);

        // A switch-case nehezen bővíthető, ha mondjuk lesz egy új ételfajta
        // if-else if- else se lenne jobb

        Food baseFood;
        switch (order.getFood()) {

            // A szakács készíti az ételt
            // A FoodChoice enum és a Food interfészt implementáló osztályok külön fejlődhetnek
            // Legfeljebb a szakács nem minden, az enumban szereplő, ételt tud értelmezni és elkészíteni
            // Illetve megjelenhetnek új ételek, de amíg az enumba nincsenek felvéve, addig nem rendelhetők
            // A FoodChoice és az ExtraChoice enum így is összeköti a Client és a Chef osztályokat (mindkettőnek
            // ismernie kell ezeket a típusokat, hogy működjön a folyamat)
            case HOTDOG:
                baseFood = new Hotdog();
                break;
            default:
                throw new IllegalArgumentException();
        }

        Food extra;
        switch (order.getExtra()) {
            case KETCHUP:
                extra = new Ketchup(baseFood);
                break;
            default:
                throw new IllegalArgumentException();
        }

        return extra;
    }
}
