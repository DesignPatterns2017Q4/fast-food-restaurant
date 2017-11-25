package com.epam.training.designpatterns.fastfoodrestaurant.Foods;

public interface Food {
    /**
     * @return the amount this food directly increases (or decreases) client happiness
     */
    default double directHappiness(){
        return 0;
    }

    /**
     * @return the amount by which this food multiplies client happiness
     */
    default double modifyHappiness() {
        return 1;
    }

    /**
     * Cooks the given food.
     */
    void prepare();

    /**
     * @return Should return true if food is edible
     */
    boolean isPrepared();

}
