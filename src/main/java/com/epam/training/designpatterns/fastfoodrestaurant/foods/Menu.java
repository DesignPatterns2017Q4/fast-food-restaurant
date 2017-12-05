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

    private final List<Class<? extends Edible>> edibles = new ArrayList<>();
    private final List<Class<? extends Condiment>> condiments = new ArrayList<>();
    private final HashMap<String, Class<? extends Food>> foodMap = new HashMap<>();

    private void setEdible(Class<? extends Edible> edible){
        edibles.add(edible);
        foodMap.put(edible.toString(), edible);
    }

    private void setCondiment(Class<? extends Condiment> condiment){
        condiments.add(condiment);
        foodMap.put(condiment.toString(), condiment);
    }

    private Menu(){
        setEdible(Chips.class);
        setEdible(HotDog.class);
        setCondiment(Ketchup.class);
        setCondiment(Mustard.class);
    }
    public static Menu getInstance(){
        return instance;
    }
    public Set<String> getAvailableFoods(){
        return foodMap.keySet();
    }
    /**
     * @return a random edible food with a random number of different condiments
     */
    public List<String> randomFoodAndCondiment() {
        List<String> randomFoods = new ArrayList<>();
        randomFoods.add(edibles.get(Math.abs(new Random().nextInt() % edibles.size())).toString()); // base Food
        int numCondiments = Math.abs(new Random().nextInt()) % condiments.size() + 1;
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < numCondiments; i++) {
            int randomIndex;
            do {
                randomIndex = Math.abs(new Random().nextInt()) % condiments.size();
            } while (seen.contains(randomIndex));
            seen.add(randomIndex);
            randomFoods.add(condiments.get(randomIndex).toString());
        }
        return randomFoods;
    }
}
