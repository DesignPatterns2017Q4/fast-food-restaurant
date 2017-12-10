package com.epam.training.designpatterns.fastfoodrestaurant.staff;

import com.epam.training.designpatterns.fastfoodrestaurant.foods.Food;
import com.epam.training.designpatterns.fastfoodrestaurant.foods.Menu;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Takes orders from the order queue, prepares the food, and puts the cooked food in the ready queue
 */
public class Cook implements Runnable {
    private final int SIMULATION_SPEED;
    private ArrayBlockingQueue<Order> orders;
    private ArrayBlockingQueue<Plate> platesReadyToServe;
    private final Menu menu;

    Cook(ArrayBlockingQueue<Order> orders, ArrayBlockingQueue<Plate> platesReadyToServe, int simulation_speed) {
        this.orders = orders;
        this.platesReadyToServe = platesReadyToServe;
        SIMULATION_SPEED = simulation_speed;
        this.menu = Menu.getInstance();
    }

    @Override
    public void run() {
        try {
            preparePlate();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void preparePlate() throws InterruptedException {
        while (true) {
            Order order = orders.take();
            System.out.println(String.format("Preparing %s ", order.toString()));
            Food cookedFood = makeFood(order.getFoods());
            platesReadyToServe.put(new Plate(cookedFood, order.getClient()));
        }
    }
    private Food makeFood(List<String> foodOrder) throws InterruptedException {
        Thread.sleep(15 * SIMULATION_SPEED);
        if (platesReadyToServe.remainingCapacity() == 0) {
            System.err.println("Restaurant has run out of plates to serve");
        }
        Food foodWithCondiment = null;
        try {
            Class<? extends Food>  baseFoodClass = menu.getFoodClass(foodOrder.get(0));
            foodWithCondiment = baseFoodClass.getConstructor().newInstance();
            for (String foodClassName : foodOrder.subList(1,foodOrder.size())){
                Class<? extends Food>  condimentFoodClass = menu.getFoodClass(foodClassName);
                foodWithCondiment = condimentFoodClass.getConstructor(Food.class)
                        .newInstance(foodWithCondiment);
            }
        } catch (IllegalAccessException | NoSuchMethodException |
                InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return foodWithCondiment;
    }
}
