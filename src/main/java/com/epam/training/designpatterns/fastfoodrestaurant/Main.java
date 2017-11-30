package com.epam.training.designpatterns.fastfoodrestaurant;

public class Main {
    public static void main(String[] args) {
        Chef chef = new Chef();
        Waiter waiter = new Waiter(chef);
        Client client = new Client(waiter, Menu.FoodType.Hotdog, Menu.ExtraType.Ketchup);
        
        Order order = client.makeOrder();
        waiter.giveOrderToChef(order);
    }    
}