package com.epam.training.designpatterns.fastfoodrestaurant;

public class Application {

    public static void main(String[] args) {

        OrderQueue orders = new OrderQueue();
        Chef chef = new Chef(orders);
        Waiter waiter = new Waiter(chef, orders);
        
        Client client1 = new Client(waiter, Menu.FoodType.Hotdog, Menu.ExtraType.Ketchup);
        Client client2 = new Client(waiter, Menu.FoodType.Chips, Menu.ExtraType.Mustard);
        
        Order order1 = client1.makeOrder();
        Order order2 = client2.makeOrder();
        waiter.addOrder(order1);
        waiter.addOrder(order2);
        chef.makeFood();
        chef.makeFood();
    }
}
