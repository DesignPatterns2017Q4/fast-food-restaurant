package com.epam.training.designpatterns.fastfoodrestaurant;

import com.epam.training.designpatterns.fastfoodrestaurant.Foods.Food;
import com.epam.training.designpatterns.fastfoodrestaurant.Foods.Menu;
import com.epam.training.designpatterns.fastfoodrestaurant.Staff.Server;

public class Client {
    private static int clientCount;

    private final Server server;
    private double happiness = 100;
    private final int clientNumber;
    private Food food;

    public Client(Server server){
        this.server = server;
        this.clientNumber = clientCount++;
    }
    public void orderFood(){
        Food food = Menu.randomFoodAndCondiment();
        System.out.println(String.format("%s ordering %s. Current happiness: %.2f",
                this.toString(), food.toString(), happiness));
        server.requestFood(this, food);
    }


    public void eatFood(Food food){
        this.food = food;
        setHappiness();
        System.out.println(String.format("%s has finished eating his %s. Current happiness: %.2f",
                this.toString(), food.toString(), happiness));
    }

    private void setHappiness() {
        happiness = (happiness + food.directHappiness()) * food.modifyHappiness();
    }


    @Override
    public String toString(){
        return "Client #" + clientNumber;
    }
}
