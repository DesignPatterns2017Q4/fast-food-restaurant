package com.epam.training.designpatterns.fastfoodrestaurant.Foods;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        //return new Meal(randomFood(foods), randomFood(condiments));
        //randomFood(condiments)
    }

    //private static <T extends Food> T randomFood(List<Class<? extends T>> list){
    //    try {
    //        Class<? extends T> chosenFood= list.get(Math.abs(new Random().nextInt() % list.size()));
    //    } catch (InstantiationException | IllegalAccessException e) {
    //        throw new RuntimeException(e);
    //    }
    //}
}
