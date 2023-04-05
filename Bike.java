package ua.lviv.iot.algo.part1.laba1;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Bike extends Transport {
    private int speed;
    private int frameSize;
    private int numberOfGears;
    private String color;
    private boolean hasBasket;

    public Bike(int id, int maxSpeed, String plateNumber, int speed, int frameSize, int numberOfGears, String color, boolean hasBasket) {
        super(id, maxSpeed, plateNumber);
        this.speed = speed;
        this.frameSize = frameSize;
        this.numberOfGears = numberOfGears;
        this.color = color;
        this.hasBasket = hasBasket;
    }

    public void attachBasket() {
        if (!hasBasket) {
            hasBasket = true;
        }
    }

    @Override
    public void accelerate(int speed) {
        this.speed += speed;
    }
}
