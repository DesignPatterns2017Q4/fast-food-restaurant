package com.epam.training.designpatterns.fastfoodrestaurant;

import com.epam.training.designpatterns.fastfoodrestaurant.entities.Client;
import com.epam.training.designpatterns.fastfoodrestaurant.entities.Order;
import com.epam.training.designpatterns.fastfoodrestaurant.entities.ReadyMeal;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.DeliveryQueue;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.OrderQueue;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.Waiter;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class WaiterTest {

    Waiter underTest;
    OrderQueue orderQueue;
    DeliveryQueue deliveryQueue;

    @Before
    public void setUp() {
        orderQueue = mock(OrderQueue.class);
        deliveryQueue = mock(DeliveryQueue.class);
        underTest = new Waiter(orderQueue, deliveryQueue);
        underTest.setOrderTakingSpeed(10);
        underTest.setDeliverySpeed(10);
    }

    @Test
    public void testTakeOrder() {
        // GIVEN
        Order order = mock(Order.class);
        // WHEN
        underTest.takeOrder(order);
        // THEN
        verify(orderQueue, times(1)).addOrder(order);
    }

    @Test
    public void testUpdate() {
        // GIVEN
        Client client = mock(Client.class);
        ReadyMeal readyMeal = mock(ReadyMeal.class);

        // WHEN
        when(deliveryQueue.isEmpty()).thenReturn(false).thenReturn(false)
                        .thenReturn(false).thenReturn(true);
        when(deliveryQueue.getNextMeal()).thenReturn(readyMeal);
        when(readyMeal.getClient()).thenReturn(client);

        underTest.update(deliveryQueue, new Object());

        // THEN
        verify(deliveryQueue, times(4)).isEmpty();
        verify(deliveryQueue, times(3)).getNextMeal();
        verify(readyMeal, times(3)).getClient();
        verify(readyMeal, times(3)).getReadyFood();
        verify(client, times(3)).consumeFood(readyMeal.getReadyFood());
    }

    @Test
    public void testSetDeliverySpeed() {
        // GIVEN
        // WHEN
        underTest.setDeliverySpeed(100);
        // THEN
        assertEquals(100, underTest.getDeliverySpeed());
    }

    @Test
    public void testSetDeliverySpeedNonValidValue() {
        // GIVEN
        // WHEN
        underTest.setDeliverySpeed(-100);
        // THEN
        assertEquals(10, underTest.getDeliverySpeed() );
    }

    @Test
    public void testSetOrderTakingSpeed() {
        // GIVEN
        // WHEN
        underTest.setOrderTakingSpeed(100);
        // THEN
        assertEquals(100, underTest.getOrderTakingSpeed());
    }

    @Test
    public void testSetOrderTakingSpeedNonValidValue() {
        // GIVEN
        // WHEN
        underTest.setOrderTakingSpeed(-100);
        // THEN
        assertEquals(10, underTest.getOrderTakingSpeed());
    }

}
