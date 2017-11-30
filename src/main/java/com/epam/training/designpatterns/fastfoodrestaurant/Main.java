package com.epam.training.designpatterns.fastfoodrestaurant;

public class Main {
    public static void main(String[] args) {
        Client client = new Client(Menu.FoodType.Hotdog, Menu.ExtraType.Ketchup);
        Chef chef = new Chef();
        Waiter waiter = new Waiter(chef);
        
        Order order = client.makeOrder();
        Food food = waiter.addOrder(order);
        System.out.println("Client happines: " + client.eatFood(food));
    }    
}