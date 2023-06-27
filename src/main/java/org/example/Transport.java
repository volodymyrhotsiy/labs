package org.example;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
abstract class Transport {
    protected int id = 0;
    protected int maxSpeed;
    protected String plateNumber;

    public abstract void accelerate(int speed);
}
