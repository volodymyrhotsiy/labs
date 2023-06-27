package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


class TransportWriterTest {
    private TransportWriter transportWriter;

    @BeforeEach
    void setUp() {
        transportWriter = new TransportWriter();
    }

    @Test
    void testWriteCreatesFile() throws FileNotFoundException {
        List<Transport> transports = new ArrayList<>();
        Car car = new Car(1, 200, "ABC123", 2, 12, 10);
        Bike bike = new Bike(2, 100, "DEF456", 50, 17, 6, "blue", true);
        transports.add(car);
        transports.add(bike);

        transportWriter.writeToFile(transports);

        File csvFile = new File("transport.csv");
        Assertions.assertTrue(csvFile.exists());
    }

    @Test
    void testWriteHasCorrectContent() throws FileNotFoundException {
        List<Transport> transports = new ArrayList<>();
        Car car = new Car(1, 200, "ABC123", 2, 12, 10);
        Bike bike = new Bike(2, 100, "DEF456", 50, 17, 6, "blue", true);
        transports.add(car);
        transports.add(bike);

        transportWriter.writeToFile(transports);

        String expectedContent = "id,maxSpeed,plateNumber,numberOfDoors,trunkVolume,maxLoad\n" +
                "1, 200, ABC123, 2, 12, 10\n" +
                "id,maxSpeed,plateNumber,speed,frameSize,numberOfGears,color,hasBasket\n" +
                "2, 100, DEF456, 50, 17, 6, blue, true\n";
        File csvFile = new File("transport.csv");
        String actualContent = TestUnits.readFileContent(csvFile);
        Assertions.assertEquals(expectedContent, actualContent);
    }
    @Test
    void testWriteToFileGroupsByType() throws FileNotFoundException {
        List<Transport> transports = new ArrayList<>();
        Car car1 = new Car(1, 200, "ABC123", 2, 12, 10);
        Car car2 = new Car(2, 250, "DEF456", 4, 20, 20);
        Bike bike1 = new Bike(3, 100, "GHI789", 50, 17, 6, "blue", true);
        Bike bike2 = new Bike(4, 120, "JKL012", 55, 18, 7, "green", false);
        transports.add(car1);
        transports.add(car2);
        transports.add(bike1);
        transports.add(bike2);

        transportWriter.writeToFile(transports);

        File csvFile = new File("transport.csv");
        String actualContent = TestUnits.readFileContent(csvFile);
        String expectedLines =
                "id,maxSpeed,plateNumber,numberOfDoors,trunkVolume,maxLoad"+"\n"+
                "1, 200, ABC123, 2, 12, 10"+"\n"+
                "2, 250, DEF456, 4, 20, 20"+"\n"+
                "id,maxSpeed,plateNumber,speed,frameSize,numberOfGears,color,hasBasket"+"\n"+
                "3, 100, GHI789, 50, 17, 6, blue, true"+"\n"+
                "4, 120, JKL012, 55, 18, 7, green, false\n";

        Assertions.assertEquals(expectedLines, actualContent);
    }
}