package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Observable;
import java.util.Random;

public class Robot extends Observable implements Runnable {
	
	Cashier cashier;
	OrderQueue newOrderQueue;
	OrderQueue readyOrderQueue;
	Random random;
	
	public Robot() {
		this.random = new Random();
	}

	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}
	
	public void setNewOrderQueue(OrderQueue newOrderQueue) {
		this.newOrderQueue = newOrderQueue;
	}

	public void setReadyOrderQueue(OrderQueue readyOrderQueue) {
		this.readyOrderQueue = readyOrderQueue;
	}
	
	private void waitSomeTime() {
		int millis = random.nextInt(5000);
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while(newOrderQueue.size() > 0) {
			Order order = newOrderQueue.pop();
			waitSomeTime();
			readyOrderQueue.put(order);
			setChanged();
			notifyObservers(order);
		}
	}

}
