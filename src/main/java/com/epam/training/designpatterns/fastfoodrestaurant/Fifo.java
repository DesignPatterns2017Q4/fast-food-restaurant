package com.epam.training.designpatterns.fastfoodrestaurant;

public interface Fifo<T> {

	void put(T element);
	
	T pop();
}
