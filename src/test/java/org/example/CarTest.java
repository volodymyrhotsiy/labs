package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    public void testAccelerate() {
        Car car = new Car(113, 120, "KPL 947", 4, 30, 10);
        car.accelerate(20);
        assertEquals(140, car.getMaxSpeed());
    }

}