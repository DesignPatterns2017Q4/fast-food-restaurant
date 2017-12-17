package com.epam.training.designpatterns.fastfoodrestaurant;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Chef {

    // 2 Map van switch-case vagy if-else if-else helyett, ezek a mapek akár externalizálhatók konfigba, könnyen bővíthetők
    // vö. SOLID elvek: Open-Closed Principle
    private Map<String, FoodFactory> foodFactories = new HashMap<>();;
    private Map<String, ExtraFactory> extraFactories = new HashMap<>();;

    {
        foodFactories.put("hotdog", new HotdogFactory());
        extraFactories.put("ketchup", new KetchupFactory());
    }

    public Food prepare(Order order) {

        System.out.println("Preparing order: " + order);

        String orderedFood = order.getFood();                           // Validáció?
        FoodFactory foodFactory = foodFactories.get(orderedFood);       // Az éppen rendelt ételhez keresünk factory-t
        Food food = foodFactory.create();                               // Polimorfikus hívás! ;-)

        String orderedExtra = order.getExtra();                         // Validáció?
        ExtraFactory extraFactory = extraFactories.get(orderedExtra);   // Az éppen rendelt extrához keresünk factory-t
        Food extra = extraFactory.create(food);                         // Polimorfikus hívás! ;-)

        return extra;
    }
}
