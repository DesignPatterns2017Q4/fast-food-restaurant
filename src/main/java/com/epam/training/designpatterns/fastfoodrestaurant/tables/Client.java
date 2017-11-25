package com.epam.training.designpatterns.fastfoodrestaurant.tables;

import com.epam.training.designpatterns.fastfoodrestaurant.foods.Food;
import com.epam.training.designpatterns.fastfoodrestaurant.foods.Menu;
import com.epam.training.designpatterns.fastfoodrestaurant.staff.Server;

import java.util.concurrent.Semaphore;

public class Client implements Runnable{
    private static int clientCount;
    private final Semaphore sema;

    private double happiness = 100;
    private final int clientNumber;
    private Food food;
    private Server server;
    private final int SIMULATION_SPEED;
    public Client(Server server, Semaphore sema, int simulation_speed){
        SIMULATION_SPEED = simulation_speed;
        this.clientNumber = clientCount++;
        this.sema = sema;
        this.server = server;
    }
    public void orderFood() throws InterruptedException {
        Food food = Menu.randomFoodAndCondiment();
        System.out.println(String.format("%s ordering %s. Current happiness: %.2f",
                this.toString(), food.toString(), happiness));
        server.takeOrder(this, food);
    }

    public void giveFoodEatAndLeave(Food food) throws InterruptedException {
        assert food.isPrepared();
        this.food = food;
        setHappiness();
        Thread.sleep(10 * SIMULATION_SPEED);
        System.out.println(String.format("%s has finished eating his %s. Final happiness: %.2f",
                this.toString(), food.toString(), happiness));
        sema.release();
    }

    private void setHappiness() {
        happiness = (happiness + food.directHappiness()) * food.modifyHappiness();
    }


    @Override
    public String toString(){
        return "Client #" + clientNumber;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5 * SIMULATION_SPEED); //Looking over the menu
            orderFood();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
