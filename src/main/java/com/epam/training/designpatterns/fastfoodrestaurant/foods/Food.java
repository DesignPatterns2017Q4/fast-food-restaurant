package com.epam.training.designpatterns.fastfoodrestaurant.foods;

public interface Food {
    /**
     * @return the amount this food directly increases (or decreases) client happiness
     */
    default double directHappiness() {
        return 0;
    }

    /**
     * @return the amount by which this food multiplies client happiness
     */
    default double modifyHappiness() {
        return 1;
    }

    /**
     * @param happiness current happiness of client
     * @return the new happiness after eating this Food
     */
    default double eat(double happiness){
        return  (happiness + directHappiness()) * modifyHappiness();
    }
}
