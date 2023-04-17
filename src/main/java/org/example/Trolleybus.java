package org.example;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Trolleybus extends Transport {
    private int routeNumber;
    private String currentStop;
    private int speed;
    private int capacity;
    private int passengers;
    private static Trolleybus instance;

    public Trolleybus(int id, int maxSpeed, String plateNumber, int routeNumber, String currentStop, int speed, int capacity, int passengers) {
        super(id, maxSpeed, plateNumber);
        this.routeNumber = routeNumber;
        this.currentStop = currentStop;
        this.speed = speed;
        this.capacity = capacity;
        this.passengers = passengers;
    }


    public static Trolleybus getInstance() {
        if (instance == null) {
            instance = new Trolleybus();
        }
        return instance;
    }
    public void stop() {
        System.out.println("Stopped at " + currentStop);
        speed = 0;
    }

    @Override
    public void accelerate(int speed) {
        this.speed += speed;
    }

    public void start() {
        speed = 20;
    }

    public void addPassenger(String passenger) {
        if (passengers < capacity) {
            passengers++;
        }
    }

    public void removePassenger(String passenger) {
        if (passengers > 0) {
            passengers--;
        }
    }
}
