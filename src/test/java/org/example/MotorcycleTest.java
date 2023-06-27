package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MotorcycleTest {
    @Test
    public void testAccelerate() {
        Motorcycle motorcycle = new Motorcycle(1, 100, "ABC123", 50, false, "red", 500);
        motorcycle.accelerate(20);
        assertEquals(70, motorcycle.getSpeed());
    }

    @Test
    public void testAttachSideCar() {
        Motorcycle motorcycle = new Motorcycle(1, 100, "ABC123", 50, false, "red", 500);
        assertFalse(motorcycle.isHasSideCar());
        motorcycle.attachSideCar();
        assertTrue(motorcycle.isHasSideCar());
    }

}