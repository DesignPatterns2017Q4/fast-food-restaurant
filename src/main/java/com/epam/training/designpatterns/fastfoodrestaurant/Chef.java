package com.epam.training.designpatterns.fastfoodrestaurant;

import com.epam.training.designpatterns.fastfoodrestaurant.Menu.ExtraType;
import com.epam.training.designpatterns.fastfoodrestaurant.Menu.FoodType;

public class Chef {
    private OrderQueue orders;
    private Food food;


    public Chef(OrderQueue orders) {
        this.orders = orders;
    }

    public void makeFood() {
        Order order = orders.getOrder();
        System.out.println("Chef: Getting order from queue.");
        
        FoodBuilder foodBuilder = new FoodBuilder(order.getFood());
        foodBuilder.addExtra(order.getExtra());
        food = foodBuilder.makeFood();
        System.out.println("Chef: I made the food on my secret food making machine.");

        System.out.println("Chef: The order is done.");
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

        public FoodBuilder addExtra(ExtraType extraType) {
            if(extraType == ExtraType.Ketchup) {
                food = new Ketchup(food);
            } else {
                food = new Mustard(food);
            }
            return this;
        }

        public Food makeFood() {
            return food;
        }
    }
}