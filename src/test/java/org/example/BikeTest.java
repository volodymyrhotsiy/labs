package org.example;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;


public class BikeTest extends TestCase {
    @Test
    public void testAccelerate() {
        Bike bike = new Bike(115, 30, "NCB 815", 20, 20, 6, "red", false);
        bike.accelerate(20);
        assertEquals(40, bike.getSpeed());
    }

    @Test
    public void testAttachSideCar() {
        Bike bike = new Bike(115, 30, "NCB 815", 20, 20, 6, "red", false);
        assertFalse(bike.isHasBasket());
        bike.attachBasket();
        assertTrue(bike.isHasBasket());
    }

}