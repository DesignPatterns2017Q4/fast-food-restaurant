package com.epam.training.designpatterns.fastfoodrestaurant.foods;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

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

    /**
     * @return a random edible food with a random number of different condiments
     */
    public static Food randomFoodAndCondiment(){
        try {
            Food baseFood = foods.get(Math.abs(new Random().nextInt() % foods.size())).newInstance();

            int numCondiments = Math.abs(new Random().nextInt() % condiments.size() + 1);
            Set<Integer> seen = new HashSet<>();
            Food foodWithCondiments = baseFood;
            for (int i=0;i<numCondiments;i++){
                int randomIndex;
                do{
                    randomIndex = new Random().nextInt() % condiments.size();
                } while (seen.contains(randomIndex));
                seen.add(randomIndex);
                Class<? extends Condiment> condimentClass= condiments.get(randomIndex);
                foodWithCondiments = condimentClass.getConstructor(Food.class).newInstance(foodWithCondiments);
            }
            return foodWithCondiments;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


}