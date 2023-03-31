package ua.lviv.iot.algo.part1.laba1;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Car extends Transport {
    int numberOfDoors;
    int trunkVolume;
    int maxLoad;

    public Car(int id, int maxSpeed, String plateNumber, int numberOfDoors, int trunkVolume, int maxLoad) {
        super(id, maxSpeed, plateNumber);
        this.numberOfDoors = numberOfDoors;
        this.trunkVolume = trunkVolume;
        this.maxLoad = maxLoad;
    }

    @Override
    public void accelerate(int speed) {
        this.maxSpeed += speed;
    }
}
