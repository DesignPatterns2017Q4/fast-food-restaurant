package com.epam.training.designpatterns.fastfoodrestaurant.foods;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Contains a list of classes that represent the menu.
 * Serves as a factory for these classes.
 */
public class Menu {
    private static final List<Class<? extends Edible>> foods = new ArrayList<>();
    private static final List<Class<? extends Condiment >> condiments = new ArrayList<>();
    static{
        foods.add(Chips.class);
        foods.add(HotDog.class);
        condiments.add(Ketchup.class);
        condiments.add(Mustard.class);
    }

    public static Food randomFoodAndCondiment(){
        try {
            Food food = foods.get(Math.abs(new Random().nextInt() % foods.size())).newInstance();
            Class<? extends Condiment> condimentClass= condiments.get(Math.abs(new Random().nextInt() % foods.size()));
            return condimentClass.getConstructor(Food.class).newInstance(food);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


}
