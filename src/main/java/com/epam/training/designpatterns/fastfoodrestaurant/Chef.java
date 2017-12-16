package com.epam.training.designpatterns.fastfoodrestaurant;

import java.lang.reflect.InvocationTargetException;

public class Chef {

    public Food prepare(Order order) {

        System.out.println("Preparing order: " + order);

        Class<? extends Food> orderedBaseFood = order.getFood(); // Unchecked assignment
        Class<? extends Food> orderedExtra = order.getExtra(); // Unchecked assignment

        Food baseFoodInstance = null;
        Food extraInstance = null;

        try {
            // Az ételek csak itt készülnek el, de a típusok (itt: Food, Hotdog és Ketchup)
            // összekötik a Client és a Chef osztályokat
            baseFoodInstance = orderedBaseFood.getConstructor().newInstance();
            // Compile time sokat elbír, későn, már run time jöhetnek hibák, pl. elírom így getConstructor(Hotdog.class)
            // És ha nincs extra?
            extraInstance = orderedExtra.getConstructor(Food.class).newInstance(baseFoodInstance);
        } catch (IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return extraInstance;
    }
}
