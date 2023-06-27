package org.example;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Motorcycle extends Transport {
    private int speed;
    private boolean hasSideCar;
    private String color;
    private int engineSize;

    public Motorcycle(int id, int maxSpeed, String plateNumber, int speed, boolean hasSideCar, String color, int engineSize) {
        super(id, maxSpeed, plateNumber);
        this.speed = speed;
        this.hasSideCar = hasSideCar;
        this.color = color;
        this.engineSize = engineSize;
    }

    @Override
    public void accelerate(int speed) {
        this.speed += speed;
    }

    public void attachSideCar() {
        if (!hasSideCar) {
            hasSideCar = true;
        }
    }
}
