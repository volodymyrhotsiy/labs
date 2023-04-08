package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrolleybusTests {
    private Trolleybus trolleybus;

    @Before
    public void setUp() {
        trolleybus = new Trolleybus(1, 60, "ABC123", 22, "stop1", 30, 40, 12);
    }

    @Test
    public void testAccelerate() {
        trolleybus.accelerate(10);
        assertEquals(40, trolleybus.getSpeed());
    }

    @Test
    public void testStop() {
        trolleybus.stop();
        assertEquals(0, trolleybus.getSpeed());
    }

    @Test
    public void testAddPassenger() {
        trolleybus.addPassenger("Alice");
        assertEquals(13, trolleybus.getPassengers());
    }

    @Test
    public void testRemovePassenger() {
        trolleybus.removePassenger("Bob");
        assertEquals(11, trolleybus.getPassengers());
    }
}
