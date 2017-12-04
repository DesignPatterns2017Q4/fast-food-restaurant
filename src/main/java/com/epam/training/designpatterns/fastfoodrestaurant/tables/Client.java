package com.epam.training.designpatterns.fastfoodrestaurant.tables;

import com.epam.training.designpatterns.fastfoodrestaurant.foods.Food;
import com.epam.training.designpatterns.fastfoodrestaurant.foods.Menu;
import com.epam.training.designpatterns.fastfoodrestaurant.staff.Server;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Knows the server, and the menu
 */
public class Client implements Runnable{
    private static int clientCount;
    private final Semaphore sema;

    private double happiness = 100;
    private final int clientNumber;
    private Food food;
    private final int SIMULATION_SPEED;
    private final Server server;

    public Client(Server server, Semaphore sema, int simulation_speed){
        SIMULATION_SPEED = simulation_speed;
        this.clientNumber = clientCount++;
        this.sema = sema;
        this.server = server;
    }
    private void orderFood() throws InterruptedException {
        Food food = Menu.randomFoodAndCondiment();
        System.out.println(String.format("%s ordering %s. Current happiness: %.2f",
                this.toString(), food.toString(), happiness));
        server.takeOrder(this, food);
    }

    public void giveFood(Food food) throws InterruptedException {
        assert food.isPrepared();
        this.food = food;
    }

    private synchronized void waitForFood() throws InterruptedException {
        while (food == null){
            wait();
        }
        eatAndLeave();
    }

    private void eatAndLeave() throws InterruptedException {
        System.out.println(String.format("%s is eating his %s", toString(), food.toString()));
        setHappiness();
        Thread.sleep(10 * SIMULATION_SPEED);
        System.out.println(String.format("%s has finished eating his and is leaving. Final happiness: %.2f",
                this.toString(), happiness));
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
            Thread.currentThread().setName(this.toString());
            Thread.sleep((Math.abs(new Random().nextInt() % 10) + 1) * SIMULATION_SPEED); //Looking over the menu
            orderFood();
            waitForFood();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
