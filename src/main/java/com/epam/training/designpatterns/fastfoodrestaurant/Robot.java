package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Queue;
import java.util.Random;

public class Robot implements Runnable {
	
	Cashier cashier;
	Queue<Order> queue;
	
	Order order;
	Random random;
	int millis;
	
	public Robot(Queue<Order> queue) {
		this.queue = queue;
	}

	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}

	public Order getOrderFromQueue() throws InterruptedException {
		while(queue.isEmpty()) {
            wait();
        }
        Order order = queue.remove();
        notifyAll();
        return order;
	}
	
	public void prepareOrder(Order order) throws InterruptedException {
		millis = random.nextInt(5000);
		Thread.sleep(millis);
	}

	public void run() {
		try {
			order = getOrderFromQueue();
			prepareOrder(order);
			cashier.foodReady(order);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
