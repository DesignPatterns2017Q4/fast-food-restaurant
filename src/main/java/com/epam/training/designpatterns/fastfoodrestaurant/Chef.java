package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Queue;

import com.epam.training.designpatterns.fastfoodrestaurant.Menu.ExtraType;
import com.epam.training.designpatterns.fastfoodrestaurant.Menu.FoodType;

public class Chef {
    private Queue<Order> orders;
    private Food food;


    public Chef(Queue<Order> orders) {
        this.orders = orders;
    }

    public void makeFood() {
        Order order = orders.remove();
        
        FoodBuilder foodBuilder = new FoodBuilder(order.getFood());
        foodBuilder.addExtra(order.getExtra());
        food = foodBuilder.makeFood();
        
        order.setDone();
    }

    public Food getFood() {
        return food;
    }

    private class FoodBuilder {
        private Food food;

        public FoodBuilder(FoodType foodType) {
            if (foodType ==  FoodType.Hotdog ) {
                food = new Hotdog();
            } else {
                food = new Chips();
            }
        }

        public void addExtra(ExtraType extraType) {
            if(extraType == ExtraType.Ketchup) {
                food = new Ketchup(food);
            } else {
                food = new Mustard(food);
            }
        }

        public Food makeFood() {
            return food;
        }
    }
}