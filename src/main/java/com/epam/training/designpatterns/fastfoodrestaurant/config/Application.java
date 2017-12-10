package com.epam.training.designpatterns.fastfoodrestaurant.config;

import com.epam.training.designpatterns.fastfoodrestaurant.simulation.RestaurantSimulator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException, InterruptedException {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext() ) {
            ctx.register(AppConfig.class);
            ctx.refresh();
            RestaurantSimulator restaurantSimulator = ctx.getBean(RestaurantSimulator.class);
            restaurantSimulator.startSimulation();
        }
    }

}
