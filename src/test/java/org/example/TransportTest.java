package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TransportTest {
    @Test
    void testGetHeaders() {
        String expectedHeaders = "id,maxSpeed,plateNumber,speed,frameSize,numberOfGears,color,hasBasket";

        Bike bike = new Bike();
        String actualHeaders = bike.getHeaders();
        Assertions.assertEquals(expectedHeaders, actualHeaders);
    }
    @Test
    void testGetValues() {
        String expectedValues = "12, 60, ABC123, 60, 17, 6, red, true";

        Bike bike = new Bike(12,60,"ABC123",60,17,6,"red",true);
        String actualValues = bike.getFieldValues();
        Assertions.assertEquals(expectedValues, actualValues);
    }

}