package org.example;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;


import java.util.List;

public class TransportManagerTests {
    private TransportManager manager;

    @BeforeEach
    public void setUp() {
        manager = new TransportManager();
        manager.addTransport(new Car(1, 120, "KPL 947", 4, 30, 10));
        manager.addTransport(new Motorcycle(2, 150, "JXG 309", 50, true, "red", 200));
        manager.addTransport(new Bike(3, 30, "NCB 815", 20, 20, 6, "red", false));
    }

    @Test
    public void testAddTransport() {
        manager.addTransport(new Car());
        manager.addTransport(new Motorcycle());
        Assertions.assertEquals(5, manager.getTransports().size());
    }

    @Test
    public void testFindAllTransportsWithMaxSpeedGraterThen() {
        List<Transport> result = manager.findAllTransportsWithMaxSpeedGraterThen(100);
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(120, result.get(0).getMaxSpeed());
        Assertions.assertEquals(150, result.get(1).getMaxSpeed());
    }

    @Test
    public void testSortTransportsPlatesAlphabetically() {
        List<Transport> result = manager.sortTransportsPlatesAlphabetically();
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals("JXG 309", result.get(0).getPlateNumber());
        Assertions.assertEquals("KPL 947", result.get(1).getPlateNumber());
        Assertions.assertEquals("NCB 815", result.get(2).getPlateNumber());
    }
}
