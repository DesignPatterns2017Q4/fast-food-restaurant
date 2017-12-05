package com.epam.training.designpatterns.fastfoodrestaurant.foods;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Contains a list of classes that represent the menu.
 * Serves as a builder for these classes.
 * Singleton, because foods should not be added at runtime
 */
public class Menu {

    private static final Menu instance = new Menu();

    private final List<Class<? extends Edible>> foods = new ArrayList<>();
    private final List<Class<? extends Condiment>> condiments = new ArrayList<>();

    private Menu(){
        foods.add(Chips.class);
        foods.add(HotDog.class);
        condiments.add(Ketchup.class);
        condiments.add(Mustard.class);
    }
    public static Menu getInstance(){
        return instance;
    }
    /**
     * @return a random edible food with a random number of different condiments
     */
    public Food randomFoodAndCondiment() {
        try {
            Food baseFood = foods.get(Math.abs(new Random().nextInt() % foods.size())).newInstance();

            int numCondiments = Math.abs(new Random().nextInt()) % condiments.size() + 1;
            Set<Integer> seen = new HashSet<>();
            Food foodWithCondiments = baseFood;
            for (int i = 0; i < numCondiments; i++) {
                int randomIndex;
                do {
                    randomIndex = Math.abs(new Random().nextInt()) % condiments.size();
                } while (seen.contains(randomIndex));
                seen.add(randomIndex);
                Class<? extends Condiment> condimentClass = condiments.get(randomIndex);
                foodWithCondiments = condimentClass.getConstructor(Food.class).newInstance(foodWithCondiments);
            }
            return foodWithCondiments;
        } catch (ArrayIndexOutOfBoundsException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


}
